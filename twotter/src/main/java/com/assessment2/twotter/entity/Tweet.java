package com.assessment2.twotter.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.assessment2.twotter.dto.TweetDto;
import com.assessment2.twotter.dto.UserDto;

@Entity
public class Tweet {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	private Users author;
	private Long posted;
	private String content;
	//private TweetDto inReplyTo;
	//private TweetDto repostOf;
	private boolean deleted;
	private String tag;
	
	public Tweet() {
		
	}
	
	public Tweet(Integer id, Long posted,String content, boolean deleted, String tag) {
		this.id = id;
		this.posted = posted;
		this.content = content;
		this.deleted = deleted;
		this.tag = tag;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Users getAuthor() {
		return author;
	}

	public void setAuthor(Users author) {
		this.author = author;
	}

	public Long getPosted() {
		return posted;
	}

	public void setPosted(Long posted) {
		this.posted = posted;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
