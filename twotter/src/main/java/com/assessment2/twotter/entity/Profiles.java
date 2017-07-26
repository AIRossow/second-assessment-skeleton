package com.assessment2.twotter.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Profiles {
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
}
