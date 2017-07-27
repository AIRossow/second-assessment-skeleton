//package com.assessment2.twotter.entity;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//
//@Entity
//public class Hashtag {
//	@Id
//	@GeneratedValue
//	private Integer id;
//	
//    @ManyToOne
//    @JoinColumn(name = "tags")
//	private String label;
//    
//	private Long firstUsed;
//	private Long lastUsed;
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
