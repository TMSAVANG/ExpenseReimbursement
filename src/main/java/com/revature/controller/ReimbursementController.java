package com.revature.controller;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.put;

import java.util.List;

import com.revature.model.Reimbursement;
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
		int state = Integer.parseInt( ctx.queryParam("state") );
		ReimbursementRepository reimbursementRepository = new ReimbursementRepository();
		reimbursementRepository.updateApproval(ref,state);
		ctx.status(200);
	};
}

