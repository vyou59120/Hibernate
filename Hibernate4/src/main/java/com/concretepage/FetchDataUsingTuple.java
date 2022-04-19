package com.concretepage;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.concretepage.pojo.Student;
import com.concretepage.util.HibernateUtil;
public class FetchDataUsingTuple {
	public static void main(String[] args) {
		CriteriaBuilder builder = HibernateUtil.getCriteriaBuilder();
		EntityManager em = HibernateUtil.getEntityManager();
		CriteriaQuery<Tuple> criteriaQuery = builder.createTupleQuery();
		Root<Student> studentRoot = criteriaQuery.from(Student.class);
		criteriaQuery.multiselect(studentRoot.get("id"),studentRoot.get("age"));
		criteriaQuery.where( builder.equal(studentRoot.get("name"),"Ram"));
		List<Tuple> tupleList = em.createQuery(criteriaQuery).getResultList();
		for (Tuple tuple : tupleList) {
		    Integer id = (Integer)tuple.get(0);
		    Integer age = (Integer)tuple.get(1);
		    System.out.println("id:"+id+", age:"+age);
		}
	}
}
