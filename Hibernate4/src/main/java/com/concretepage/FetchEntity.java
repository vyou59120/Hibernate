package com.concretepage;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.concretepage.pojo.Student;
import com.concretepage.util.HibernateUtil;

public class FetchEntity {
	public static void main(String[] args) {
		CriteriaBuilder builder = HibernateUtil.getCriteriaBuilder();
		EntityManager em = HibernateUtil.getEntityManager();
		CriteriaQuery<Student> criteriaQuery = builder.createQuery(Student.class);
		Root<Student> studentRoot = criteriaQuery.from(Student.class);
		criteriaQuery.select(studentRoot);
		criteriaQuery.where( builder.equal(studentRoot.get("name"),"Ram"));
		List<Student> students = em.createQuery(criteriaQuery).getResultList();
		for ( Student student : students) {
		    System.out.println("id:"+student.getId()+", age:"+student.getAge());
		}
	}
}
 