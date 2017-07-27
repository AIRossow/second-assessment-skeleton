package com.assessment2.twotter.entity;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Tweet {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	private Users author;
	private Long posted;
	private String content;
//	@ManyToOne
//	private Users
	//private TweetDto inReplyTo;
	//private Tweet repostOf;
	private boolean deleted;
//	@OneToMany//(targetEntity = Hashtag.class, mappedBy = "Hashtag.label")
//	@JoinColumn(name = "tagId")
//	private Set<Hashtag> tag;
	String tag;
	
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

//	public Tweet getRepostOf() {
//		return repostOf;
//	}
//
//	public void setRepostOf(Tweet repostOf) {
//		this.repostOf = repostOf;
//	}
}
