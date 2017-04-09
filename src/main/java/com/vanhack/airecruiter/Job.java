package com.vanhack.airecruiter;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Job {

	private Integer idJob;

	private String aboutThisRole;

	private String responsibilities;

	private String qualifications;

	private String position;

	private Company company;

	private Skill principalSkill;

	private Collection<Skill> skills;

	private Boolean deleted;

	private Collection<JobCompatibility> jobCompatibilities;

	@Id
	public Integer getIdJob() {
		return idJob;
	}

	public void setIdJob(Integer idJob) {
		this.idJob = idJob;
	}

	public String getAboutThisRole() {
		return aboutThisRole;
	}

	public void setAboutThisRole(String aboutThisRole) {
		this.aboutThisRole = aboutThisRole;
	}

	public String getResponsibilities() {
		return responsibilities;
	}

	public void setResponsibilities(String responsibilities) {
		this.responsibilities = responsibilities;
	}

	public String getQualifications() {
		return qualifications;
	}

	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}

	@ManyToOne
	@JoinColumn(name = "PRINCIPALSKILL")
	public Skill getPrincipalSkill() {
		return principalSkill;
	}

	public void setPrincipalSkill(Skill principalSkill) {
		this.principalSkill = principalSkill;
	}

	@ManyToMany
	@JoinTable(name = "JOBSKILL", joinColumns = @JoinColumn(name = "IDJOB"), inverseJoinColumns = @JoinColumn(name = "IDSKILL"))
	public Collection<Skill> getSkills() {
		return skills;
	}

	public void setSkills(Collection<Skill> skills) {
		this.skills = skills;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@ManyToOne
	@JoinColumn(name = "IDCOMPANY")
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@OneToMany(mappedBy = "job")
	public Collection<JobCompatibility> getJobCompatibilities() {
		return jobCompatibilities;
	}

	public void setJobCompatibilities(Collection<JobCompatibility> jobCompatibilities) {
		this.jobCompatibilities = jobCompatibilities;
	}

}