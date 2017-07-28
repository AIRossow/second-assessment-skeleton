package com.assessment2.twotter.controller;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment2.twotter.dto.TweetDto;
import com.assessment2.twotter.entity.Credentials;
import com.assessment2.twotter.service.TweetService;
import com.assessment2.twotter.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("Tweet")
public class TweetController {

		private TweetService tweetService;
		private UserService userService;
	
		public TweetController(TweetService tweetService, UserService userService) {
			this.tweetService = tweetService;
			this.userService = userService;
		}
		
		@GetMapping
		@ApiOperation(value = "", nickname = "getAllTweets")
		public List<TweetDto> getAll() {
			return tweetService.getAll();
		}
		
		@GetMapping("{id}")
		@ApiOperation(value = "", nickname = "getTweetById")
		public TweetDto getById(@PathVariable Integer id) {
			return tweetService.getById(id);
		}
	
		@PostMapping
		@ApiOperation(value = "", nickname = "postNewTweet")
		public TweetDto post(@RequestBody TweetDto tweetDto, HttpServletResponse httpResponse) {
			if(userService.checkCred(tweetDto.getCreds()))
				return tweetService.post(tweetDto);
			else {
			    httpResponse.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			    return null;
			}
		}
		
		@DeleteMapping("{id}")
		@ApiOperation(value = "", nickname = "deleteProjectManagerAtId")
		public void delete(@PathVariable Integer id, HttpServletResponse httpResponse) {
			tweetService.delete(id);
		}
		
		@PostMapping("{id}/repost")
		@ApiOperation(value = "", nickname = "repostTweet")
		public TweetDto repost(@PathVariable Integer id, @RequestBody Credentials cred) {
			return tweetService.repost(id, cred);
		}
	}
