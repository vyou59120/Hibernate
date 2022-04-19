package com.concretepage;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.concretepage.pojo.Student;
import com.concretepage.util.HibernateUtil;

public class FetchWrapper {
	public static void main(String[] args) {
		CriteriaBuilder builder = HibernateUtil.getCriteriaBuilder();
		EntityManager em = HibernateUtil.getEntityManager();
		CriteriaQuery<StudentWrapper> criteriaQuery = builder.createQuery(StudentWrapper.class);
		Root<Student> studentRoot = criteriaQuery.from(Student.class);
		criteriaQuery.select(builder.construct(StudentWrapper.class, studentRoot.get("id"),studentRoot.get("age")));
		criteriaQuery.where( builder.equal(studentRoot.get("name"),"Ram"));
		List<StudentWrapper> wrapperList = em.createQuery(criteriaQuery).getResultList();
		for (StudentWrapper w : wrapperList) {
		    int id = w.getId();
		    int age = w.getAge();
		    System.out.println("id:"+id+", age:"+age);
		}
    }
}
