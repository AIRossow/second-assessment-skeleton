package com.assessment2.twotter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assessment2.twotter.mapper.UserMapper;
import com.assessment2.twotter.dto.TweetDto;
import com.assessment2.twotter.dto.UserDto;
import com.assessment2.twotter.entity.Credentials;
import com.assessment2.twotter.entity.Profiles;
import com.assessment2.twotter.entity.Tweet;
import com.assessment2.twotter.entity.Users;
import com.assessment2.twotter.service.UserService;
import com.assessment2.twotter.mapper.TweetMapper;
import com.assessment2.twotter.repository.TweetRepository;

@Service
public class TweetService {

	private TweetRepository tweetRepo;
	private TweetMapper tweetMap;
	private UserService userService;
	private UserMapper userMap;
	

	public TweetService(TweetRepository tweetRepo, TweetMapper tweetMap, UserService userService, UserMapper userMap) {
		this.tweetRepo = tweetRepo;
		this.tweetMap = tweetMap;
		this.userService = userService;
		this.userMap = userMap;
		
	}
	
	public List<TweetDto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public int post(TweetDto tweetDto) {
		Tweet tweet = tweetMap.fromDto(tweetDto);
		Users user = userMap.fromDto(userService.getUser(tweetDto.getCreds().getUsername()));
		tweet.setAuthor(user);
		tweet.setContent(tweetDto.getContent());
		System.out.println(tweetDto.getContent());
		//userService.addTweet(user, tweetMap.fromDto(tweetDto));
		tweetRepo.save(tweet);
		return tweetDto.getId();
	}

	public void put(Long id, TweetDto tweetDto) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
