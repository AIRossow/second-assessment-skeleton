package com.assessment2.twotter.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assessment2.twotter.dto.UserDto;
import com.assessment2.twotter.entity.Credentials;
import com.assessment2.twotter.entity.Profiles;
import com.assessment2.twotter.entity.Tweet;
import com.assessment2.twotter.entity.Users;
import com.assessment2.twotter.mapper.UserMapper;
import com.assessment2.twotter.repository.UserRepository;

@Service
public class UserService {
	private Map<String, Users> users = new HashMap<String, Users>();
	private UserMapper userMap;
	private UserRepository userRepo;

	public UserService(UserMapper userMap, UserRepository userRepo) {
		this.userMap = userMap;
		this.userRepo = userRepo;
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

	public UserDto update(UserDto user) {
		// TODO Auto-generated method stub
		return null;
	}

	public void follow(Credentials cred, String username) {
		// TODO Auto-generated method stub
		
	}

	public void unfollow(Credentials cred, String username) {
		// TODO Auto-generated method stub
		
	}
	
	public void addTweet(UserDto userDto, Tweet tweet) {
		Users user = userMap.fromDto(userDto);
		System.out.println(user);
		System.out.println(tweet);
		users.get(user.getProfile().getCreds().getUsername()).addTweet(tweet);
	}

}
