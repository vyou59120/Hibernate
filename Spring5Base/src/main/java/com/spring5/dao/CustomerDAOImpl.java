package com.spring5.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring5.models.Customer;


@Repository
public class CustomerDAOImpl implements CustomerDAO {

//	@Autowired
//	private SessionFactory sessionFactory;
	
	@PersistenceContext
	EntityManager entityManager;

//	EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.spring5.");
	
//	public static EntityManager getEntityManager() {
//	    return emf.createEntityManager();
//	}
	
	@Override
	public List<Customer> getCustomers() {
//		Session session = sessionFactory.getCurrentSession();
//		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
		Root<Customer> root = cq.from(Customer.class);
		cq.select(root);
//		Query query = session.createQuery(cq);
		Query query = entityManager.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void deleteCustomer(int id) {
//		Session session = sessionFactory.getCurrentSession();
//		Customer book = session.byId(Customer.class).load(id);
//		session.delete(book);
		Customer user = getCustomer(id);
		entityManager.remove(user);
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
//		Session currentSession = sessionFactory.getCurrentSession();
//		currentSession.saveOrUpdate(theCustomer);
		entityManager.persist(theCustomer);
//	    return theCustomer;
	}

	@Override
	public Customer getCustomer(int theId) {
//		Session currentSession = sessionFactory.getCurrentSession();
//		Customer theCustomer = currentSession.get(Customer.class, theId);
//		return theCustomer;
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	    CriteriaQuery<Customer> criteria = builder.createQuery(Customer.class);
	    Root<Customer> root = criteria.from(Customer.class);
	    TypedQuery<Customer> query = entityManager
	        .createQuery(criteria.select(root).where(
	            builder.equal(root.<String> get("id"), theId)));
	    try {
	        return query.getSingleResult();
	    }
	    catch (NoResultException e) {
	        return null;
	    }
	}
}
