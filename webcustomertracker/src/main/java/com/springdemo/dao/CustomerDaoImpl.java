package com.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springdemo.entities.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionfactory;
	
	public List<Customer> getCustomers() {
		
		//get the current hibernate session
		Session session=sessionfactory.openSession();
		
		//create a query
		Query<Customer> theQuery=session.createQuery("from Customer",Customer.class);
		
		//execute query and get result list
		List<Customer> customers=theQuery.getResultList();
		
		//return the results
		return customers;
	}

	public void saveCustomer(Customer customer) {
		
		Session session=sessionfactory.getCurrentSession();
		
		session.saveOrUpdate(customer);
		
	}

	public Customer getCustomer(int theId) {
		
		Session session=sessionfactory.getCurrentSession();
		
		Customer customer=session.get(Customer.class,theId);
		
		return customer;
	}

	public void deleteCustomer(int theId) {
		
		Session session=sessionfactory.getCurrentSession();
		
		Query theQuery=session.createQuery("delete from Customer where id=:customerId");
		
		theQuery.setParameter("customerId",theId);
		
		theQuery.executeUpdate();
		
	//	Customer customer=session.get(Customer.class,theId);
		
		//session.delete(customer);
		
		
	}

	public List<Customer> searchCustomers(String theSearchName) {

		Session session=sessionfactory.getCurrentSession();
		
		Query<Customer> theQuery=null;
		
		if((theSearchName)!=null && theSearchName.trim().length()>0)
		{
			theQuery =session.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
			theQuery.setParameter("theName", "%" + theSearchName.trim().toLowerCase() + "%");
		}
		else 
		{
			// theSearchName is empty ... so just get all customers
			theQuery =session.createQuery("from Customer", Customer.class);			
		}

		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
						
				// return the results		
		return customers;

	}

}
