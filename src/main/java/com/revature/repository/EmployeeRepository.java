package com.revature.repository;

import com.revature.model.Employee;
import com.revature.model.Reimbursement;
import com.revature.util.HibernateSessionFactory;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

public class EmployeeRepository 
{
	public Employee getEmployee(String username)
	{
		Session s = null;
		Transaction tx = null;

		Employee result = null;
		
		try
		{
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
				
			result = s.createQuery("FROM Employee WHERE username = '" + username +"'", Employee.class).getSingleResult();
		}
			
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
			
		finally
		{
			s.close();
		}

		
		return result;
	}
	
}
