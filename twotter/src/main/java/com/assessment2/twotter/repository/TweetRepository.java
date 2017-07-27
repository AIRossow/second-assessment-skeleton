package com.assessment2.twotter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.assessment2.twotter.dto.TweetDto;
import com.assessment2.twotter.entity.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Integer> {

	List<TweetDto> findByauthor_id(Integer tempId);

}
