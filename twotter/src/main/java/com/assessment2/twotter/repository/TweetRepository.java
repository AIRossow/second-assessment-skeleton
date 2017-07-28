package com.assessment2.twotter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.assessment2.twotter.entity.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Integer> {

	List<Tweet> findByAuthor_idIs(Integer tempId);

}
