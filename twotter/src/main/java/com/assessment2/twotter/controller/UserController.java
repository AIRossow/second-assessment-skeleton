package com.assessment2.twotter.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment2.twotter.dto.UserDto;
import com.assessment2.twotter.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {
	private UserService userService;
	
	@GetMapping
	public List<UserDto> getAllUsers() {
		return userService.getAll();
	}
	
	@GetMapping("@{username}")
	public UserDto getByUsername(@PathVariable String username ) {
		return userService.getUser(username);
	}
}
