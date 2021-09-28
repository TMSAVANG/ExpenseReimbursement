package com.revature.service;

import com.revature.model.Employee;
import com.revature.repository.EmployeeRepository;

public class EmployeeService 
{
	public boolean login(String username, String password)
	{
		boolean valid = false;
		
		EmployeeRepository empRepo = new EmployeeRepository();
		
		Employee user = empRepo.getEmployee(username);
		
		if (user.getPassword().equals(password))
		{
			valid = true;
		}
		
		return valid;
	}
}
