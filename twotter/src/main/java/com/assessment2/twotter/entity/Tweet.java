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
	private Timestamp posted;
	//private TweetDto inReplyTo;
	//private TweetDto repostOf;
	private boolean deleted;
	private String tag;
	
	public Tweet(Integer id, Timestamp posted, boolean deleted, String tag) {
		this.id = id;
		this.posted = posted;
		this.deleted = deleted;
		this.tag = tag;
		
	}
}
