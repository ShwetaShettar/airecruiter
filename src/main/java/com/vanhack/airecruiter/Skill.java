package com.vanhack.airecruiter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Skill {

	@Id
	private Integer idSkill;
	
	private String skillName;
	
	private Boolean active;

	public Integer getIdSkill() {
		return idSkill;
	}

	public void setIdSkill(Integer idSkill) {
		this.idSkill = idSkill;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idSkill == null) ? 0 : idSkill.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Skill other = (Skill) obj;
		if (idSkill == null) {
			if (other.getIdSkill() != null)
				return false;
		} else if (!idSkill.equals(other.getIdSkill()))
			return false;
		return true;
	}
	
	
}