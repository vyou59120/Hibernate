package com.spring5.service;

import java.util.List;
import java.util.Optional;

import com.spring5.models.Customer;



public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Optional<Customer> getCustomer(int theId);

	public void deleteCustomer(int theId);
	
}
