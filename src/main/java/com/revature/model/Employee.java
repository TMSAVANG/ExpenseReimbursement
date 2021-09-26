package com.revature.model;

import java.util.Objects;

public class Employee 
{
	private int employee_id;
	private String name;
	
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

	
	
	
	@Override
	public int hashCode() 
	{
		return Objects.hash(employee_id, name);
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
		return employee_id == other.employee_id && Objects.equals(name, other.name);
	}

	@Override
	public String toString() 
	{
		return "Employee [employee_id=" + employee_id + ", name=" + name + "]";
	}

	
	public Employee()
	{
		super();
	}
	
	public Employee(int employee_id, String name) 
	{
		super();
		this.employee_id = employee_id;
		this.name = name;
	}
	
	
	
}
