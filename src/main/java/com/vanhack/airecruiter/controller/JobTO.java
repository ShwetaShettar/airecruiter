package com.vanhack.airecruiter.controller;

import java.util.List;

public class JobTO {

	private Integer idJob;
	
	private String position;
	
	private String companyName;
	
	private List<UserTO> users;

	public Integer getIdJob() {
		return idJob;
	}

	public void setIdJob(Integer idJob) {
		this.idJob = idJob;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public List<UserTO> getUsers() {
		return users;
	}

	public void setUsers(List<UserTO> users) {
		this.users = users;
	}
	
	
}
