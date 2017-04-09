package com.vanhack.airecruiter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		try {
			EntityManager em = emf.createEntityManager();
			try {

				EntityTransaction transaction = em.getTransaction();
				transaction.begin();
				try {
					em.setFlushMode(FlushModeType.COMMIT);

					System.out.println("Removing old data...");
					em.createQuery("DELETE FROM JobCompatibility").executeUpdate();

					System.out.println("Loading users...");
					List<User> users = em.createQuery("SELECT user FROM User user", User.class).getResultList();

					System.out.println("Loading jobs...");
					List<Job> jobs = em.createQuery("SELECT job FROM Job job", Job.class).getResultList();

					System.out.println("Crossing data...");
					for (Job job : jobs) {
						if (job.getDeleted() != null && !job.getDeleted()) {
							System.out.println ("idJob="+ job.getIdJob());
							Set<Skill> allSkills = new HashSet<Skill>(job.getSkills());
							allSkills.add(job.getPrincipalSkill());
							removeInactiveSkills(allSkills);

							for (User user : users) {
								final Set<Skill> overlap = new HashSet<Skill>(allSkills);
								overlap.retainAll(user.getSkills());

								final JobCompatibility jobCompatibility = new JobCompatibility();
								jobCompatibility.setJob(job);
								jobCompatibility.setUser(user);
								jobCompatibility.setScore(overlap.size());
								jobCompatibility.setMaxScore(allSkills.size());

								em.persist(jobCompatibility);
							}
						}
					}

					System.out.println("Persisting...");
					transaction.commit();
				} catch (RuntimeException | Error e) {
					transaction.rollback();
					throw e;
				}

			} finally {
				em.close();
			}
		} finally {
			emf.close();
		}
	}

	private static void removeInactiveSkills(Collection<Skill> skills) {
		for (Iterator<Skill> i = skills.iterator(); i.hasNext();) {
			Skill skill = i.next();
			if (skill.getActive() == null || !skill.getActive()) {
				i.remove();
			}
		}
	}

}