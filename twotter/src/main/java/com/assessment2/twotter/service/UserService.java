package com.assessment2.twotter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.assessment2.twotter.dto.UserDto;
import com.assessment2.twotter.entity.User;

@Service
public class UserService {
	private List<User> users = new ArrayList<User>();

	public List<UserDto> getAll() {
		return null;
	}

	public UserDto getUser(String username) {
		
		return null;
	}

}
