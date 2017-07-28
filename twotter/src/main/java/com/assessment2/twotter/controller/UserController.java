package com.assessment2.twotter.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
	public UserDto getByUsername(@PathVariable String username, HttpServletResponse httpResponse ) {
		if(valServ.userExists(username))
			return userService.getUser(username);
		else {
			httpResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
			
	}
	
	@GetMapping("@{username}/tweets")
	public List<TweetDto> getUserTweets(@PathVariable String username, HttpServletResponse httpResponse) {
		if(valServ.userExists(username))
			return userService.getUserTweets(username);
		else {
			httpResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}

	@GetMapping("@{username}/followers")
	public List<UserDto> getFollowers(@PathVariable String username, HttpServletResponse httpResponse) {
		if(valServ.userExists(username))
			return userService.getFollowers(username);
		else {
			httpResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
	
	@GetMapping("@{username}/following")
	public List<UserDto> getFollowing(@PathVariable String username, HttpServletResponse httpResponse) {
		if(valServ.userExists(username))
			return userService.getFollowing(username);
		else {
			httpResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
	
	@GetMapping("@{username}/feed")
	public List<TweetDto> getUserFeed(@PathVariable String username, HttpServletResponse httpResponse) {
		if(valServ.userExists(username))
			return userService.getUserFeed(username);
		else {
			httpResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
	
	@GetMapping("@{username}/mentions")
	public List<TweetDto> getMentions(@PathVariable String username, HttpServletResponse httpResponse) {
		if(valServ.userExists(username))
			return userService.getMentions(username);
		else {
			httpResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}

	@PostMapping
	public UserDto postNewUser(@RequestBody Profiles profile, HttpServletResponse httpResponse) {
		if(valServ.userAvailable(profile.getCreds().getUsername()))
			return userService.createUser(profile);
		
		if(!valServ.userAvailable(profile.getCreds().getUsername()) && !valServ.userExists(profile.getCreds().getUsername()))
			return userService.activateUser(profile);
		
		else {
			httpResponse.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			return null;
		}
	}
	
	@PatchMapping("@{username}")
	public UserDto updateUser(@RequestBody Profiles profile, HttpServletResponse httpResponse) {
		if(valServ.userExists(profile.getCreds().getUsername()))
			return userService.update(profile);
		else {
			httpResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
	
	@PostMapping("@{username}/follow")
	public void followUser(@PathVariable String username, @RequestBody Credentials cred, HttpServletResponse httpResponse) {
		if(userService.checkCred(cred) && valServ.userExists(username))
			userService.follow(cred, username); 
		else
			httpResponse.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
	}
	
	@PostMapping("@{username}/unfollow")
	public void unfollowUser(@PathVariable String username, @RequestBody Credentials cred, HttpServletResponse httpResponse) {
		if(userService.checkCred(cred) && valServ.userExists(username))
			userService.unfollow(cred, username);
		else
			httpResponse.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
	}
	
	@DeleteMapping("@{username}")
	public void delete(@PathVariable String username, @RequestBody Credentials cred, HttpServletResponse httpResponse) {
		if(userService.checkCred(cred))
			userService.delete(username);
		else
			httpResponse.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
	}
}
