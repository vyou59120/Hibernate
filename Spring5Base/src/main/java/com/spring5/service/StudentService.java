package com.spring5.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.spring5.xml.student.Student;

@WebService(serviceName = "StudentService")
public class StudentService {

	@WebMethod(operationName = "getStudentDetails")
	public Student getStudentDetails(@WebParam(name = "name") String studentName) {
		Student student = new Student();
		student.setAddress("loos");
		student.setName("vann");
		student.setStandard(12);
		return student;
	}
}
