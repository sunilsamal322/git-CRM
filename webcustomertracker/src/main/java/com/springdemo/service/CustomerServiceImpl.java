package com.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.dao.CustomerDao;
import com.springdemo.entities.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	@Transactional
	public List<Customer> getCustomers() {
		
		return customerDao.getCustomers();
	}
	
	@Transactional
	public void saveCustomer(Customer customer) {
		
		customerDao.saveCustomer(customer);
	}
	@Transactional
	public Customer getCustomer(int theId) {
		
		return customerDao.getCustomer(theId);
	}
	
	@Transactional
	public void deleteCustomer(int theId) {
		
		customerDao.deleteCustomer(theId);
	}
	@Transactional
	public List<Customer> searchCustomers(String theSearchName) {
		
		return customerDao.searchCustomers(theSearchName);
	}

}
