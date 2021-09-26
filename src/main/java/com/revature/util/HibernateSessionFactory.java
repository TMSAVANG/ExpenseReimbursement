package com.revature.util;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/*
 * We are no longer explicitly using JDBC, so we don't need our ConnectionFactory.
 * That said, we will need a way to pass Hibernate sessions around our
 * application. As such, we'll build our SessionFactory, which will return
 * sessions based on the configuration details specified in our
 * hibernate.cfg.xml file, here.
 */
public class HibernateSessionFactory {

	/*
	 * There is only ever going to be a single SessionFactory in this application.
	 * This follows the singleton design pattern.
	 */
	private static SessionFactory sessionFactory;

	public static Session getSession() 
	{
		if(sessionFactory == null) 
		{
			try 
			{
				
			Properties props = new Properties();
        	FileReader connectionProperties = new FileReader("src/main/resources/connection.properties");
        	props.load(connectionProperties);
        	String urlString = "jdbc:mariadb://"
        			+ props.getProperty("endpoint") + ":"
        			+ props.getProperty("port") + "/"
        			+ props.getProperty("dbname");
				
			sessionFactory = new Configuration().configure()
					.setProperty("hibernate.connection.url", urlString)
					.setProperty("hibernate.connection.username", props.getProperty("username"))
					.setProperty("hibernate.connection.password", props.getProperty("password"))
					.buildSessionFactory();
			}
			
			catch(HibernateException H_e) 
			
			{
				H_e.printStackTrace();
			}
			
			catch(FileNotFoundException FNF_e)
			{
				FNF_e.printStackTrace();
			}
			
			catch(IOException IO_e)
			{
				IO_e.printStackTrace();
			}
		}
		
		return sessionFactory.getCurrentSession();
	}
}
