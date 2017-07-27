package com.assessment2.twotter.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment2.twotter.dto.TweetDto;
import com.assessment2.twotter.dto.UserDto;
import com.assessment2.twotter.entity.Credentials;
import com.assessment2.twotter.entity.Profiles;
import com.assessment2.twotter.service.UserService;
import com.assessment2.twotter.service.ValidateService;

@RestController
@RequestMapping("users")
public class UserController {
	private UserService userService;
	private ValidateService valServ;
	
	public UserController(UserService userService, ValidateService valServ){
		this.userService = userService;
		this.valServ = valServ;
	}
	
	@GetMapping
	public List<UserDto> getAllUsers() {
		return userService.getAll();
	}
	
	@GetMapping("@{username}")
	public UserDto getByUsername(@PathVariable String username ) {
		return userService.getUser(username);
	}
	
	@GetMapping("@{username}/tweets")
	public List<TweetDto> getUserTweets(@PathVariable String username) {
		return userService.getUserTweets(username);
	}

	@GetMapping("@{username}/followers")
	public List<UserDto> getFollowers(@PathVariable String username) {
		return userService.getFollowers(username);
	}
	
	@GetMapping("@{username}/following")
	public List<UserDto> getFollowing(@PathVariable String username) {
		return userService.getFollowing(username);
	}
	
	@GetMapping("@{username}/feed")
	public List<TweetDto> getUserFeed(@PathVariable String username) {
		return userService.getUserFeed(username);
	}
	
	@GetMapping("@{username}/mentions")
	public List<TweetDto> getMentions(@PathVariable String username) {
		return userService.getMentions(username);
	}

	@PostMapping
	public UserDto postNewUser(@RequestBody Profiles profile) {
		if(valServ.userAvailable(profile.getCreds().getUsername()))
			return userService.createUser(profile);
		
		else
			return null;
	}
	
	@PatchMapping("@{username}")
	public UserDto updateUser(@RequestBody Profiles profile) {
		return userService.update(profile);
	}
	
	@PostMapping("@{username}/follow")
	public void followUser(@PathVariable String username, @RequestBody Credentials cred) {
		if(userService.checkCred(cred))
			userService.follow(cred, username); 
	}
	
	@PostMapping("@{username}/unfollow")
	public void unfollowUser(@PathVariable String username, @RequestBody Credentials cred) {
		if(userService.checkCred(cred))
			userService.unfollow(cred, username);
	}
	
	@DeleteMapping("@{username}")
	public void delete(@PathVariable String username, @RequestBody Credentials cred) {
		if(userService.checkCred(cred))
			userService.delete(username);
	}
}
