package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.CustomerCrudRepository;
import com.example.demo.dao.CustomerJpaRepository;
import com.example.demo.dao.CustomerReallyRepository;
import com.example.demo.model.Customer;

@Service
@Transactional
public class CustomerServiceImp implements CustomerService {

	@Autowired
	public CustomerReallyRepository CustomerReallyRepository;

	@Autowired
	CustomerJpaRepository customerJpaRepository;

	@Override
	//save methodu
	public void saveCustomer(Customer customer) {
	
		customerJpaRepository.save(customer);
	}
//listeleme methodu
	@Override
	public List<Customer> findallCustomers() {
		
		return customerJpaRepository.findAll(new Sort(Sort.Direction.ASC, "id"));

	}
//deletemethodu
	public void DeleteCustomerById(Long id) {
		customerJpaRepository.deleteById(id);
	}
	//update methodu
	public void UpdatedCustomer(Long id, Customer customer) {
		Optional<Customer> optionalCustomer= customerJpaRepository.findById(id);
		customer.setId(id);
		customerJpaRepository.save(customer);
	}
	
	@Override
	public Customer findCustomerById(Long id) {
		return customerJpaRepository.findById(id).get();
	}
}
