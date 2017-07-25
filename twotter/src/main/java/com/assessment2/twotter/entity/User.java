package com.assessment2.twotter.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.context.annotation.Profile;

import com.assessment2.twotter.dto.ProfileDto;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Integer id;
	private Profile profile;
	private Timestamp joined;
	
	@Embedded
	private Credentials cred;
	
	@OneToMany(mappedBy = "id")
	private List<Tweet> tweets = new ArrayList<Tweet>();
	
	@ManyToMany
	private List<Integer>follows = new ArrayList<Integer>();
	private boolean deleted;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Timestamp getJoined() {
		return joined;
	}

	public void setJoined(Timestamp joined) {
		this.joined = joined;
	}

	public Credentials getCred() {
		return cred;
	}

	public void setCred(Credentials cred) {
		this.cred = cred;
	}

	public List<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(List<Tweet> tweets) {
		this.tweets = tweets;
	}

	public List<Integer> getFollows() {
		return follows;
	}

	public void setFollows(List<Integer> follows) {
		this.follows = follows;
	}
	
}
