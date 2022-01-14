package com.springdemo.dao;

import java.util.List;

import com.springdemo.entities.Customer;

public interface CustomerDao {
	
	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer customer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

	public List<Customer> searchCustomers(String theSearchName); 
}
