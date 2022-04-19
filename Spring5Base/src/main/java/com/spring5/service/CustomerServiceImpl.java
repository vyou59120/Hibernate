package com.spring5.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring5.dao.CustomerDAO;
//import com.spring5.exception.ResourceNotFoundException;
import com.spring5.models.Customer;
import com.spring5.repository.CustomerRepository;



@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
//	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
//		return customerRepository.findAll();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
//		customerDAO.saveCustomer(theCustomer);
		customerRepository.save(theCustomer);
	}

	@Override
	@Transactional
	public Optional<Customer> getCustomer(int theId){
//		return customerDAO.getCustomer(theId);
		return customerRepository.findById(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
//		customerDAO.deleteCustomer(theId);
		customerRepository.deleteById(theId);
	}
}





