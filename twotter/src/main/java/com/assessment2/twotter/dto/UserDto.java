package com.assessment2.twotter.dto;

public class UserDto {
	private Integer id;
	private String username;
	private ProfileDto profile;
	private Long joined;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public ProfileDto getProfile() {
		return profile;
	}
	public void setProfile(ProfileDto profile) {
		this.profile = profile;
	}
	public Long getJoined() {
		return joined;
	}
	public void setJoined(Long joined) {
		this.joined = joined;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
