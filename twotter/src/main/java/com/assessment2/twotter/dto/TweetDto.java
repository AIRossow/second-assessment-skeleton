package com.assessment2.twotter.dto;

import javax.persistence.Embedded;

import com.assessment2.twotter.entity.Credentials;

public class TweetDto {
	@Embedded
	private Credentials creds;
	
	private String username;
	private Integer id;
//	private UserDto author;
	private Long posted;
	private String content;
	//private TweetDto inReplyTo;
	private TweetDto repostOf;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
//	public UserDto getAuthor() {
//		return author;
//	}
//	public void setAuthor(UserDto author) {
//		this.author = author;
//	}
	public Long getPosted() {
		return posted;
	}
	public void setPosted(Long posted) {
		this.posted = posted;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Credentials getCreds() {
		return creds;
	}
	public void setCreds(Credentials creds) {
		this.creds = creds;
	}
	public TweetDto getRepostOf() {
		return repostOf;
	}
	public void setRepostOf(TweetDto repostOf) {
		this.repostOf = repostOf;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
