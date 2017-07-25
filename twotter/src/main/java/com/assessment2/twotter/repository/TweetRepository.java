package com.assessment2.twotter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assessment2.twotter.entity.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Integer> {

}
