package com.vanhack.airecruiter.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vanhack.airecruiter.Job;
import com.vanhack.airecruiter.JobCompatibility;
import com.vanhack.airecruiter.User;

@RestController
@Transactional
public class JobsService {

	@PersistenceContext
	private EntityManager em;

	@RequestMapping(path = "/jobs", method = RequestMethod.GET)
	public List<JobTO> readJobs() {
		System.out.println("jobs");
		List<JobTO> jobs = new ArrayList<JobTO>();
		for (Job job : em.createQuery("SELECT job FROM Job job WHERE job.deleted = false", Job.class).getResultList()) {
			Integer idJob = job.getIdJob();
			String position = job.getPosition();
			String companyName = job.getCompany().getName();

			JobTO jobTO = new JobTO();
			jobTO.setIdJob(idJob);
			jobTO.setCompanyName(companyName);
			jobTO.setPosition(position);
			jobs.add(jobTO);
		}

		return jobs;
	}

	@RequestMapping(path = "/jobs/{id}", method = RequestMethod.GET)
	public JobTO readJob(@PathVariable("id") Integer idJob) {
		Job job = em.find(Job.class, idJob);

		String position = job.getPosition();
		String companyName = job.getCompany().getName();

		List<UserTO> users = new ArrayList<UserTO>();
		for (JobCompatibility jobCompatibility : job.getJobCompatibilities()) {
			User user = jobCompatibility.getUser();
			String firstName = user.getFirstName();
			String lastName = user.getLastName();

			int score = jobCompatibility.getScore();
			int maxScore = jobCompatibility.getMaxScore();

			UserTO userTO = new UserTO();
			userTO.setFirstName(firstName);
			userTO.setLastName(lastName);
			userTO.setScore(BigDecimal.valueOf(score).multiply(BigDecimal.valueOf(100))
					.divide(BigDecimal.valueOf(maxScore), 4, BigDecimal.ROUND_HALF_EVEN));
			users.add(userTO);
		}
		Collections.sort(users, new Comparator<UserTO>() {

			@Override
			public int compare(UserTO o1, UserTO o2) {
				return -o1.getScore().compareTo(o2.getScore());
			}

		});

		JobTO jobTO = new JobTO();
		jobTO.setIdJob(idJob);
		jobTO.setCompanyName(companyName);
		jobTO.setPosition(position);
		jobTO.setUsers(users);

		return jobTO;
	}
}