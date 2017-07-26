package com.assessment2.twotter.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Users {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Embedded
	private Profiles profile;
	private long joined;
	
//	@Embedded
//	private Credentials cred = new Credentials();
	
	@OneToMany(mappedBy = "author")
	private List<Tweet> tweets = new ArrayList<Tweet>();
	
	@ManyToMany(mappedBy = "youFollow")
	private List<Users>followedBy = new ArrayList<Users>();
	
	@ManyToMany
	private List<Users>youFollow = new ArrayList<Users>();
	private boolean deleted;

	public Users(Integer id, long joined, Profiles profile, Credentials cred, List<Tweet>tweets, List<Users> f1, List<Users>f2) {
		this.id = id;
		this.profile = profile;
		this.joined = joined;
//		this.cred = cred;
		this.tweets = tweets;
		this.followedBy = f1;
		this.youFollow = f2;
	}
	
	public Users() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Profiles getProfile() {
		return profile;
	}

	public void setProfile(Profiles profile) {
		this.profile = profile;
	}

	public Long getJoined() {
		return joined;
	}

	public void setJoined(long joined) {
		this.joined = joined;
	}

//	public Credentials getCred() {
//		return cred;
//	}
//
//	public void setCred(Credentials cred) {
//		this.cred = cred;
//	}

	public List<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(List<Tweet> tweets) {
		this.tweets = tweets;
	}
	
	public void addTweet(Tweet tweet) {
		tweets.add(0, tweet);
	}

//	public List<Integer> getFollows() {
//		return follows;
//	}
//
//	public void setFollows(List<Integer> follows) {
//		this.follows = follows;
//	}
	
}
