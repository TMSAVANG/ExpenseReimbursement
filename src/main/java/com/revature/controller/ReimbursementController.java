package com.revature.controller;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.put;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.repository.ReimbursementRepository;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class ReimbursementController 
{
	
	public ReimbursementController(Javalin app)
	{
		app.routes(() ->
		{
			path("/reimbursements", () ->
			{
				get(findAllReimbursements);
			});
			
			path("/update", () ->
			{
				put(updateApproval);
			});
			
			path("/submit", () ->
			{
				post(submitReimbursement);
			});
		});
	}
	
	private Handler findAllReimbursements = ctx -> 
	{
		ReimbursementRepository reimbursementRepository = new ReimbursementRepository();
        ctx.json(reimbursementRepository.findAll());	
        ctx.status(200);
	};
	
	private Handler updateApproval = ctx ->
	{
		int ref = Integer.parseInt( ctx.queryParam("ref") );
		int appr = Integer.parseInt( ctx.queryParam("appr") );
		System.out.println(ref + "\n" + appr);
		ReimbursementRepository reimbursementRepository = new ReimbursementRepository();
		reimbursementRepository.updateApproval(ref,appr);
		String jsonString = "{\"reference_num\":" + ref +", \"approval\":" + appr + "}";
		ObjectMapper mapper = new ObjectMapper();
		JsonNode updateJSON = mapper.readTree(jsonString);
		ctx.json(updateJSON);
		ctx.status(200);
	};
	
	private Handler submitReimbursement = ctx ->
	{
		int emp_id = Integer.parseInt( ctx.queryParam("emp_id") );
		double amt = Double.parseDouble( ctx.queryParam("amt") );
		String rson = ctx.queryParam("rson");
		ReimbursementRepository reimbursementRepository = new ReimbursementRepository();
		reimbursementRepository.submitReimbursement(emp_id, amt, rson);
		String jsonString = "{\"employee_id\":" + emp_id +", \"amount\":" + amt + ", \"reason\":\"" + rson +"\"}";
		ObjectMapper mapper = new ObjectMapper();
		JsonNode submitJSON = mapper.readTree(jsonString);
		ctx.json(submitJSON);
		ctx.status(201);
	};
}

