package com.assessment2.twotter.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assessment2.twotter.dto.TweetDto;
import com.assessment2.twotter.dto.UserDto;
import com.assessment2.twotter.entity.Credentials;
import com.assessment2.twotter.entity.Profiles;
import com.assessment2.twotter.entity.Tweet;
import com.assessment2.twotter.entity.Users;
import com.assessment2.twotter.mapper.TweetMapper;
import com.assessment2.twotter.mapper.UserMapper;
import com.assessment2.twotter.repository.TweetRepository;
import com.assessment2.twotter.repository.UserRepository;

@Service
public class UserService {
	private Map<String, Users> users = new HashMap<String, Users>();
	private UserMapper userMap;
	private UserRepository userRepo;
	private TweetMapper tweetMap;
	private TweetRepository tweetRepo;

	public UserService(UserMapper userMap, UserRepository userRepo, TweetRepository tweetRepo, TweetMapper tweetMap) {
		this.userMap = userMap;
		this.userRepo = userRepo;
		this.tweetRepo = tweetRepo;
		this.tweetMap = tweetMap;
	}
	
	public List<UserDto> getAll() {
		List<Users> results = userRepo.findAll();
		return results.stream().map(userMap::toDto).collect(Collectors.toList());
	}

	public UserDto getUser(String username) {
		Integer tempId = userRepo.findByUser(username);
		return userMap.toDto(userRepo.getOne(tempId));
	}

	@Transactional
	public UserDto createUser(Profiles profile) {
		Users user = new Users();
		user.setProfile(profile);
		user.setJoined(System.currentTimeMillis());
		users.put(profile.getCreds().getUsername(), user);
		UserDto userDto = userMap.toDto(user);
		userRepo.saveAndFlush(user);
		return userDto;
	}

	public UserDto update(Profiles profile) {
		Integer tempId = userRepo.findByUser(profile.getCreds().getUsername());
		Users user = userRepo.getOne(tempId);
		user.setProfile(profile);
		userRepo.save(user);
		return userMap.toDto(user);
	}

	public void follow(Credentials cred, String username) {
		Integer tempId = userRepo.findByUser(username);
		Integer tempId2 = userRepo.findByUser(cred.getUsername());
		Users userToFollow = userRepo.getOne(tempId);
		Users userFollower = userRepo.getOne(tempId2);
		userToFollow.addFollower(userFollower);
		userFollower.addFallowedUser(userToFollow);
		userRepo.save(userToFollow);
		userRepo.save(userFollower);
		
	}

	public void unfollow(Credentials cred, String username) {
		Integer tempId = userRepo.findByUser(username);
		Integer tempId2 = userRepo.findByUser(cred.getUsername());
		Users userToUnfollow = userRepo.getOne(tempId);
		Users userUnfollowing = userRepo.getOne(tempId2);
		userToUnfollow.removeFollower(userUnfollowing);
		userUnfollowing.removeFallowedUser(userToUnfollow);
		userRepo.save(userToUnfollow);
		userRepo.save(userUnfollowing);
	}

	public List<TweetDto> getUserTweets(String username) {
		Integer tempId = userRepo.findByUser(username);
		List<Tweet> results = tweetRepo.findByAuthor_idIs(tempId);
		return results.stream().map(tweetMap::toDto).collect(Collectors.toList());
	}

	public void delete(String username) {
		Integer tempId = userRepo.findByUser(username);
		Users user = userRepo.getOne(tempId);
		user.setDeleted(true);
		userRepo.save(user);
	}

}
