//package com.assessment2.twotter.entity;
//
//import java.util.Set;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
//
//@Entity
//public class Hashtag {
//	@Id
//	@GeneratedValue
//	@ManyToOne(targetEntity = Tweet.class)
//	private Integer id;
//	
//	private String label;
//    
//	private Long firstUsed;
//	private Long lastUsed;
//	
//	public Hashtag() {
//		
//	}
//	
//	public Hashtag(String label, Long firstUsed, Long lastUsed) {
//		this.label = label;
//		this.firstUsed = firstUsed;
//		this.lastUsed = lastUsed;
//	}
//	
//	public String getLabel() {
//		return label;
//	}
//	public void setLabel(String label) {
//		this.label = label;
//	}
//	public Long getFirstUsed() {
//		return firstUsed;
//	}
//	public void setFirstUsed(Long firstUsed) {
//		this.firstUsed = firstUsed;
//	}
//	public Long getLastUsed() {
//		return lastUsed;
//	}
//	public void setLastUsed(Long lastUsed) {
//		this.lastUsed = lastUsed;
//	}
//}
