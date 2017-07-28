package com.assessment2.twotter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.assessment2.twotter.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

	@Query("SELECT id FROM Users WHERE username = ?1")
	Integer findByUser(String usernameToFind);

	@Query("SELECT id FROM Users WHERE username = ?1 AND password = ?2")
	Integer checkCred(String username, String password);

	@Query("SELECT id FROM Users WHERE username = ?1 AND deleted = false")
	Integer findExists(String username);

	List<Users> findByDeletedFalse();
}
