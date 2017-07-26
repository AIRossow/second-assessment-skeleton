package com.assessment2.twotter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.assessment2.twotter.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {
	
}
