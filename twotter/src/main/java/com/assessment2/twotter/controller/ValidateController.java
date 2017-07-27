package com.assessment2.twotter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment2.twotter.service.ValidateService;

@RestController
@RequestMapping("validate")
public class ValidateController {

	private ValidateService validateService;
	
	public ValidateController(ValidateService validateService) {
		this.validateService = validateService;
	}

	@GetMapping("username/exists/@{username}")
	boolean userExists(@PathVariable String username) {
		return validateService.userExists(username);
	}
	
	@GetMapping("username/available/@{username}")
	boolean userAvailable(@PathVariable String username) {
		return validateService.userAvailable(username);
	}
}
