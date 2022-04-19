//package com.spring5.service;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ws.server.endpoint.annotation.Endpoint;
//import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
//import org.springframework.ws.server.endpoint.annotation.RequestPayload;
//import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
//import com.spring5.repository.StudentRepository;
//import com.spring5.xml.student.StudentDetailsRequest;
//import com.spring5.xml.student.StudentDetailsResponse;
//
//
//@Endpoint
//public class StudentEndpoint {
//	private static final String NAMESPACE_URI = "http://spring5.com/xml/student";
//
//	private StudentRepository StudentRepository;
//
//	@Autowired
//	public StudentEndpoint(StudentRepository StudentRepository) {
//		this.StudentRepository = StudentRepository;
//	}
//
//	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "StudentDetailsRequest")
//	@ResponsePayload
//	public StudentDetailsResponse getStudent(@RequestPayload StudentDetailsRequest request) {
//		StudentDetailsResponse response = new StudentDetailsResponse();
//		response.setStudent(StudentRepository.findStudent(request.getName()));
//
//		return response;
//	}
//}