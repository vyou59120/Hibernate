package com.concretepage;


import com.concretepage.entities.Student;
import com.concretepage.utils.HibernateUtil;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "studentService")
@ApplicationScoped
public class StudentService {
     

    public List<Student> getStudentsList(){
//    	List<Student> students = new ArrayList<>();
//    	Student student1 = new Student(1L,32L, "van");
//    	Student student2 = new Student(1L,36L, "Ram");
//    	students.add(student1);
//    	students.add(student2);
    	CriteriaBuilder builder = HibernateUtil.getCriteriaBuilder();
		EntityManager em = HibernateUtil.getEntityManager();
		CriteriaQuery<Student> criteriaQuery = builder.createQuery(Student.class);
		Root<Student> studentRoot = criteriaQuery.from(Student.class);
		criteriaQuery.select(studentRoot);
		
		List<Student> students = em.createQuery(criteriaQuery).getResultList();
		
		return students;
    }
}