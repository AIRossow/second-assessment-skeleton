package com.assessment2.twotter.dto;

import java.sql.Timestamp;

import com.assessment2.twotter.entity.Credentials;

public class TweetDto {
	private Credentials creds;
	private Integer id;
//	private UserDto author;
//	private Timestamp posted;
	private String content;
	//private TweetDto inReplyTo;
	//private TweetDto repostOf;
	
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
//	public Timestamp getPosted() {
//		return posted;
//	}
//	public void setPosted(Timestamp posted) {
//		this.posted = posted;
//	}
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
	
}
