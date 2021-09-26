package com.revature.model;

import java.util.Objects;

public class Manager extends Employee
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
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(employee_id, name);
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manager other = (Manager) obj;
		return employee_id == other.employee_id && Objects.equals(name, other.name);
	}

	public Manager()
	{
		super();
	}
	
	public Manager(int employee_id, String name) 
	{
		super(employee_id, name);
	}
	
	
	
}
