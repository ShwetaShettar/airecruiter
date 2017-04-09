package com.vanhack.airecruiter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Company {

	private Integer idCompany;

	private String name;

	@Id
	public Integer getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(Integer idCompany) {
		this.idCompany = idCompany;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
