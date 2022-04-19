package com.concretepage;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.concretepage.entities.Student;
import com.concretepage.utils.HibernateUtil;


public class FetchOneColumn {
	public static void main(String[] args) {
		CriteriaBuilder builder = HibernateUtil.getCriteriaBuilder();
		EntityManager em = HibernateUtil.getEntityManager();
		CriteriaQuery<String> criteriaQuery = builder.createQuery(String.class);
		Root<Student> studentRoot = criteriaQuery.from(Student.class);
		criteriaQuery.select(studentRoot.get("name").as(String.class));
		criteriaQuery.where(builder.equal(studentRoot.get("age"),"22"));
		List<String> nameList = em.createQuery(criteriaQuery).getResultList();
		for (String name : nameList) {
		    System.out.println(name);
		}
	}
} 