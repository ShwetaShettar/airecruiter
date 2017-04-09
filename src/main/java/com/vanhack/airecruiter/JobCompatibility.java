package com.vanhack.airecruiter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class JobCompatibility {

	private Long idJobCompatibility;

	private Job job;

	private User user;

	private int score;
	
	private int maxScore;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdJobCompatibility() {
		return idJobCompatibility;
	}

	public void setIdJobCompatibility(Long idJobCompatibility) {
		this.idJobCompatibility = idJobCompatibility;
	}

	@ManyToOne
	@JoinColumn(name = "IDJOB")
	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	@ManyToOne
	@JoinColumn(name = "IDUSER")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}

}