package com.concretepage;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.concretepage.pojo.Student;
import com.concretepage.util.HibernateUtil;

public class FetchMultipleColumns {
	public static void main(String[] args) {
		CriteriaBuilder builder = HibernateUtil.getCriteriaBuilder();
		EntityManager em = HibernateUtil.getEntityManager();
		CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
		Root<Student> studentRoot = criteriaQuery.from(Student.class);
		criteriaQuery.select(builder.array(studentRoot.get("id"),studentRoot.get("age")));
		criteriaQuery.where( builder.equal(studentRoot.get("name"),"Ram"));
		List<Object[]> dataArray = em.createQuery(criteriaQuery).getResultList();
		for (Object[] values : dataArray) {
		    Integer id = (Integer) values[0];
		    Integer age = (Integer) values[1];
		    System.out.println("id:"+id+", age:"+age);
		}
	}
}
