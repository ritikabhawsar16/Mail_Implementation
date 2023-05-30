package com.learnmail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learnmail.model.EmailRequest;
import com.learnmail.service.EmailService;

@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;
	
	@PostMapping("/sendemail")
	public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request )
	{
		System.out.println(request);
		
		boolean result= this.emailService.sendEmail(request.getSubject(), request.getMessage(), request.getTo());
		
		if(result)
		{
			return ResponseEntity.ok("Email is Sent Successfully...!!!");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email not Sent...!");
		}
	}
}
