package com.spring_ai_jdbc_presistentMemory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring_ai_jdbc_presistentMemory.service.PresistentMemoryInMysqlService;

@RestController
public class PresistentMemoryInMysqlController {

	@Autowired
	private PresistentMemoryInMysqlService service;
	
	@GetMapping("/ask")
	public String response(@RequestParam String message, String conversationId) {
		return service.response(message, conversationId);
	}
}
