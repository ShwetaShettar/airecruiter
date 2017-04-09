package com.vanhack.airecruiter.controller;

import java.math.BigDecimal;

public class UserTO {

	private String firstName;
	
	private String lastName;
	
	private BigDecimal score;

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

	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}
	
}