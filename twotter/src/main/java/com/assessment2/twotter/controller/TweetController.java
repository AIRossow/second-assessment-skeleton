package com.assessment2.twotter.controller;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assessment2.twotter.dto.TweetDto;
import com.assessment2.twotter.dto.UserDto;
import com.assessment2.twotter.entity.Credentials;
import com.assessment2.twotter.entity.Users;
import com.assessment2.twotter.service.TweetService;
import com.assessment2.twotter.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("Tweet")
public class TweetController {

		private TweetService tweetService;
	
		public TweetController(TweetService tweetService) {
			this.tweetService = tweetService;
		}
		
		@GetMapping
		@ApiOperation(value = "", nickname = "getAllTweets")
		public List<TweetDto> getAll() {
			return tweetService.getAll();
		}
	
		@RequestMapping(method = RequestMethod.HEAD, value = "{id}")
		@ApiOperation(value = "", nickname = "projectManagerExistsForId")
		public void has(@PathVariable Long id, HttpServletResponse httpResponse) {
	
		}
	
//		@GetMapping("{id}")
//		@ApiOperation(value = "", nickname = "getProjectManagerById")
//		public ProjectManagerDto get(@PathVariable Long id) {
//			
//		}
	
		@PostMapping
		@ApiOperation(value = "", nickname = "postNewTweet")
		public int post(@Validated Credentials cred, @RequestBody TweetDto tweetDto, HttpServletResponse httpResponse) {
			int id = tweetService.post(cred, tweetDto);
			httpResponse.setStatus(HttpServletResponse.SC_CREATED);
			return id;
		}
		
		@PutMapping("{id}")
		@ApiOperation(value = "", nickname = "putProjectManagerWithId")
		public void put(@PathVariable Long id, @RequestBody @Validated TweetDto tweetDto, HttpServletResponse httpResponse) {
			tweetService.put(id, tweetDto);
		}
		
		@DeleteMapping("{id}")
		@ApiOperation(value = "", nickname = "deleteProjectManagerAtId")
		public void delete(@PathVariable Long id, HttpServletResponse httpResponse) {
			tweetService.delete(id);
		}
	}
