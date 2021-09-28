package com.revature;

import java.sql.SQLException;
import java.util.List;

import com.revature.model.Employee;
import com.revature.model.Reimbursement;
import com.revature.repository.EmployeeRepository;
import com.revature.repository.ReimbursementRepository;
import com.revature.controller.EmployeeController;
import com.revature.controller.ReimbursementController;

import io.javalin.Javalin;


public class Driver 
{
	public static void main(String[] args) 
	{
		Javalin app = Javalin.create().start(4444);

		EmployeeController empControl = new EmployeeController(app);
		ReimbursementController reimControl = new ReimbursementController(app);
		ReimbursementRepository reimRepo = new ReimbursementRepository();
		EmployeeRepository emplRepo = new EmployeeRepository();

	}

}
