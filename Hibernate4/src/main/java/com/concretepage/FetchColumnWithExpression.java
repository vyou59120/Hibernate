package com.concretepage;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.concretepage.pojo.Student;
import com.concretepage.util.HibernateUtil;

public class FetchColumnWithExpression {
	public static void main(String[] args) {
		CriteriaBuilder builder = HibernateUtil.getCriteriaBuilder();
		EntityManager em = HibernateUtil.getEntityManager();
		CriteriaQuery<Integer> criteriaQuery = builder.createQuery(Integer.class);
		Root<Student> studentRoot = criteriaQuery.from(Student.class);
		criteriaQuery.select(builder.max(studentRoot.get("age").as(Integer.class)));
		criteriaQuery.where( builder.equal(studentRoot.get("name"),"Ram"));
		Integer maxAge = em.createQuery(criteriaQuery).getSingleResult();
		System.out.println("Max Age:"+ maxAge);
	}
}
