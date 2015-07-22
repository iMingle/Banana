package org.mingle.banana.spring.jdbc;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class JpaTemplateSpitterDao {
	@PersistenceContext
	private EntityManager em;

	public SpitterJPA getSpitterById(long id) {
		return em.find(SpitterJPA.class, id);
	}

	public void addSpitter(SpitterJPA spitter) {
		em.persist(spitter);
	}

	public void saveSpitter(SpitterJPA spitter) {
		em.merge(spitter);
	}

}
