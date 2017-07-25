package com.assessment2.twotter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assessment2.twotter.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
}
