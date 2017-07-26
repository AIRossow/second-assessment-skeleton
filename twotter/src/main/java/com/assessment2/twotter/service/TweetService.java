package com.assessment2.twotter.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assessment2.twotter.mapper.UserMapper;
import com.assessment2.twotter.dto.TweetDto;
import com.assessment2.twotter.dto.UserDto;
import com.assessment2.twotter.entity.Credentials;
import com.assessment2.twotter.entity.Users;
import com.assessment2.twotter.mapper.TweetMapper;
import com.assessment2.twotter.repository.TweetRepository;

@Service
public class TweetService {

	private TweetRepository tweetRepo;
	private TweetMapper tweetMap;
	private UserService userService;
	private UserMapper userMap;
	
	public List<TweetDto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public int post(Credentials cred, TweetDto tweetDto) {
		UserDto user = userService.getUser(cred.getUsername());
		userService.addTweet(user, tweetMap.fromDto(tweetDto));
		tweetRepo.save(tweetMap.fromDto(tweetDto));
		return tweetDto.getId();
	}

	public void put(Long id, TweetDto tweetDto) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
