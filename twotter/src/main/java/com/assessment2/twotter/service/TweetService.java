package com.assessment2.twotter.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assessment2.twotter.mapper.UserMapper;
import com.assessment2.twotter.dto.TweetDto;
import com.assessment2.twotter.entity.Credentials;
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
		List<Tweet> results = tweetRepo.findAll();
		return results.stream().map(tweetMap::toDto).collect(Collectors.toList());
	}

	@Transactional
	public TweetDto post(TweetDto tweetDto) {
		Tweet tweet = tweetMap.fromDto(tweetDto);
		Users user = userMap.fromDto(userService.getUser(tweetDto.getCreds().getUsername()));
		tweet.setAuthor(user);
		tweet.setContent(tweetDto.getContent());
		tweet.setPosted(System.currentTimeMillis());
		tweetRepo.save(tweet);
		tweetDto.setUsername(tweetDto.getCreds().getUsername());
		return tweetDto;
	}


	public void delete(Integer id) {
		Tweet tweet = tweetRepo.getOne(id);
		tweet.setDeleted(true);
		tweetRepo.save(tweet);
		
	}

	public TweetDto getById(Integer id) {
		return tweetMap.toDto(tweetRepo.getOne(id));
	}

	public TweetDto repost(Integer id, Credentials cred) {
		TweetDto tweetDto = new TweetDto();
		TweetDto repost = getById(id);
		tweetDto.setRepostOf(repost);
		tweetDto.setCreds(cred);
		tweetDto.setContent(repost.getContent());
		return post(tweetDto);
	}

}
