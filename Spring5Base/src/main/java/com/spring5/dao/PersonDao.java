package com.spring5.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.spring5.models.Person;

@Repository
public class PersonDao {
	private static final String JPA_UNIT_NAME = "jsf-crud";
	
	@PersistenceContext
	EntityManager entityManager;

	
	public List<Person> selectAll() {
		List<Person> persons = entityManager.createQuery(
				"select p from Person p").getResultList();
		return persons;
	}

	
	public Person insert(Person u) {
		entityManager.getTransaction().begin();
		entityManager.persist(u);
		entityManager.getTransaction().commit();
		return u;
	}

	
	public Person update(Person u) {
		entityManager.getTransaction().begin();
		u = entityManager.merge(u);
		entityManager.getTransaction().commit();
		return u;
	}

	
	public void delete(Person u) {
		entityManager.getTransaction().begin();
		u = entityManager.merge(u);
		entityManager.remove(u);
		entityManager.getTransaction().commit();
	}

//	protected EntityManager entityManager {
//		if (entityManager == null) {
//			entityManager = Persistence.createEntityManagerFactory(
//					JPA_UNIT_NAME).createEntityManager();
//		}
//		return entityManager;
//	}
}
