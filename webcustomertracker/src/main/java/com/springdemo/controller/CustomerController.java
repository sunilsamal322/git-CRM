package com.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springdemo.dao.CustomerDao;
import com.springdemo.entities.Customer;
import com.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/list")
	public String listCustomers(Model model)
	{
		//get the customers form the dao
		List<Customer> theCustomers=customerService.getCustomers();
		
		//add the customer list to the model
		model.addAttribute("customers",theCustomers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String addCustomer(Model model)
	{
		Customer theCustomer=new Customer();
		model.addAttribute("customer",theCustomer);
		return "add-customer";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer)
	{
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String updateCustomer(@RequestParam("customerId") int theId,Model model)
	{
		//get the customer from the database
		Customer theCustomer=customerService.getCustomer(theId);
		
		model.addAttribute("customer",theCustomer);
		
		return "add-customer";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId)
	{
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/search")
	public String searchCustomer(@RequestParam("theSearchName") String theSearchName,Model model)
	{
		List<Customer> theCustomers=customerService.searchCustomers(theSearchName);
		model.addAttribute("customers", theCustomers);
		return "list-customers";
	}
}
