package com.assessment2.twotter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment2.twotter.dto.UserDto;
import com.assessment2.twotter.entity.Credentials;
import com.assessment2.twotter.entity.Profiles;
import com.assessment2.twotter.entity.Users;
import com.assessment2.twotter.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {
	private UserService userService;
	
	public UserController(UserService userService){
		this.userService = userService;
	}
	
	@GetMapping
	public List<UserDto> getAllUsers() {
		return userService.getAll();
	}
	
	@GetMapping("@{username}")
	public UserDto getByUsername(@PathVariable String username ) {
		return userService.getUser(username);
	}
	
	@PostMapping
	public UserDto postNewUser(@RequestBody Profiles profile) {
		return userService.createUser(profile);
	}
	
	@PatchMapping("@{username}")
	public UserDto updateUser(@RequestBody UserDto user) {
		return userService.update(user);
	}
	
	@PostMapping("@{username}/follow")
	public void followUser(@PathVariable String username, @RequestBody Credentials cred) {
		userService.follow(cred, username);
	}
	
	@PostMapping("@{username}/unfollow")
	public void unfollowUser(@PathVariable String username, @RequestBody Credentials cred) {
		userService.unfollow(cred, username);
	}
}
