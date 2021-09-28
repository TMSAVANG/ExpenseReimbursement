package com.revature.controller;

import static io.javalin.apibuilder.ApiBuilder.get;

import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.put;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.repository.ReimbursementRepository;
import com.revature.service.EmployeeService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class EmployeeController 
{
	public EmployeeController(Javalin app)
	{
		app.routes(() ->
		{
			path("/login", () ->
			{
				post(loginToMain);
			});
		
		});
	}
	
	private Handler loginToMain = ctx -> 
	{
		EmployeeService empServ = new EmployeeService();
		boolean valid = empServ.login( ctx.queryParam("username"), ctx.queryParam("password") );
		String jsonString = "{\"valid\":"+valid+"}";
		ObjectMapper mapper = new ObjectMapper();
		JsonNode validJSON = mapper.readTree(jsonString);
		ctx.json(validJSON);
		ctx.status(200);
	};
}
