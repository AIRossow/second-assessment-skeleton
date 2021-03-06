package com.assessment2.twotter.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Profiles {
	
	private Credentials creds;
	
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Credentials getCreds() {
		return creds;
	}
	public void setCreds(Credentials creds) {
		this.creds = creds;
	}
}
