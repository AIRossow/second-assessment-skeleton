package com.assessment2.twotter.dto;

import java.sql.Timestamp;

public class TweetDto {
	private Integer id;
	private UserDto author;
	private Timestamp posted;
	private TweetDto inReplyTo;
	private TweetDto repostOf;
	
}
