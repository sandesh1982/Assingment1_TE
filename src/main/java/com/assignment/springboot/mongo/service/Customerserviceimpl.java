package com.assignment.springboot.mongo.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.springboot.mongo.dao.Customerdao;
import com.assignment.springboot.mongo.model.Customer;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

@Service
public class Customerserviceimpl implements Customerservice {

	@Autowired
	Customerdao dao;

	@Override
	public void createCustomer(List<Customer> cust) {
		dao.saveAll(cust);
	}
	
	@Override
	@Cacheable(value="customer")  
	public Collection<Customer> getAllCustomers() {
		return (Collection<Customer>) dao.findAll();
	}


	@Override
	@Cacheable(value="customer",key="#id") 
	public Customer findCustomerById(int id) {
		return dao.findById(id);
	}


	@Override
	 @CacheEvict(value = "customer",allEntries = true) 
	public void deleteCustomerById(int id) {
		dao.deleteById(id);
	}


	@Override
	@CacheEvict(value = "customer", allEntries=true) 
	public void updateCustomer(Customer cust) {
		dao.save(cust);
	}


	@Override
	@CacheEvict(value = "customer",allEntries = true)
	public void deleteAllCustomers() {
		dao.deleteAll();
	}
}