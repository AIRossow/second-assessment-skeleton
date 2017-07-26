package com.assessment2.twotter.dto;

import java.sql.Timestamp;

public class UserDto {
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
}
