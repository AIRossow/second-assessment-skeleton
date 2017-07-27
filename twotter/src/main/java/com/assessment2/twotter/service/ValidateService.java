package com.assessment2.twotter.service;

import org.springframework.stereotype.Service;

import com.assessment2.twotter.repository.UserRepository;

@Service
public class ValidateService {
	private UserRepository userRepo;
	
	public ValidateService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	public boolean userExists(String username) {
		Integer tempId = userRepo.findExists(username);
		if(tempId == null)
			return false;
		else
			return !userRepo.getOne(tempId).isDeleted();
	}

	public boolean userAvailable(String username) {
		return (userRepo.findByUser(username) == null);
	}

}
