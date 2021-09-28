package com.revature.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity

@Table(name = "employees")
public class Employee 
{
	@Id
	@Column(name = "employee_id")
	private int employee_id;
	@Column
	private String name;
	@Column
	private boolean manager_status;
	@Column
	String username;
	@Column
	String password;
	
	public int getEmployee_id() 
	{
		return employee_id;
	}
	
	public void setEmployee_id(int employee_id) 
	{
		this.employee_id = employee_id;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public boolean isManager_status() 
	{
		return manager_status;
	}
	
	public void setManager_status(boolean manager_status) 
	{
		this.manager_status = manager_status;
	}
	
	public String getUsername() 
	{
		return username;
	}
	
	public void setUsername(String username) 
	{
		this.username = username;
	}
	
	public String getPassword() 
	{
		return password;
	}
	
	public void setPassword(String password) 
	{
		this.password = password;
	}
	@Override
	public int hashCode() {
		return Objects.hash(employee_id, manager_status, name, password, username);
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return employee_id == other.employee_id && manager_status == other.manager_status
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}
	@Override
	public String toString() 
	{
		return "Employee [employee_id = " + employee_id + ", name = " + name + ", manager_status = " + manager_status
				+ ", username = " + username + ", password = " + password + "]";
	}
	
	
	
	
}
