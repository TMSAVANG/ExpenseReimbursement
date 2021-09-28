package com.revature;

import java.sql.SQLException;
import java.util.List;

import com.revature.model.Employee;
import com.revature.model.Reimbursement;
import com.revature.repository.EmployeeRepository;
import com.revature.repository.ReimbursementRepository;
import com.revature.controller.ReimbursementController;

import io.javalin.Javalin;


public class Driver 
{
	public static void main(String[] args) 
	{
		Javalin app = Javalin.create().start(4444);

		ReimbursementController reimbursementController = new ReimbursementController(app);
		ReimbursementRepository reimRepo = new ReimbursementRepository();
		EmployeeRepository emplRepo = new EmployeeRepository();
		
		System.out.println(emplRepo.getEmployee("two.deux"));
	}

}
