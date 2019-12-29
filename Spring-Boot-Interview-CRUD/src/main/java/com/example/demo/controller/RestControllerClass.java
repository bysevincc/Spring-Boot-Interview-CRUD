package com.example.demo.controller;

import java.awt.PageAttributes.MediaType;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CustomerCrudRepository;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/rest")
public class RestControllerClass {
	@Autowired
	CustomerCrudRepository repository;

	@Autowired
	CustomerService customerService;

	// tek data kontrol edilmesi postman de de denendi
	// http://localhost:8080/rest/Customer/id
	@GetMapping(value = "/Customer/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id) {
		Customer customers = customerService.findCustomerById(id);
		System.out.println(
				"-------------------------------------------------------------------------------------------------");

		return ResponseEntity.ok(customers);
	}

	// tek datanın silinmesi postman de de denendi
	// http://localhost:8080/rest/DeleteCustomer/id
	@DeleteMapping(value = "/DeleteCustomer/{id}")
	public String DeleteCustomer(@PathVariable("id") Long id) {
		customerService.DeleteCustomerById(id);
		return "Removed Data";
	}

	// http://localhost:8080/rest/DeleteCustomer/id
	@PutMapping(value = "/UpdateCustomer/{id}")
	public ResponseEntity<Customer> UpdateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer) {

		customerService.UpdatedCustomer(id, customer);
		return ResponseEntity.noContent().build();
	}

	// tum dataya select
	// http://localhost:8182/rest/findall
	@GetMapping(value = "/Customers")
	public ResponseEntity<List<Customer>> getCustomers() {
		List<Customer> customers = customerService.findallCustomers();

		return ResponseEntity.ok(customers);
	}

	// coklu veri ornegi
	@RequestMapping("/save")
	public String process() {
		// tekli data kaydetme
		customerService.saveCustomer(new Customer("Hasan", "Erbas", 23, "hasanerbas@hotmail.com"));

		// listeolarak kaydetme
		repository.saveAll(Arrays.asList(new Customer("Recep", "Dag", 85, "recepdag@gmail.com"),
				new Customer("Fatih", "Yardım", 51, "deneme2@yahoo.com"),
				new Customer("Adem", "Yılmaz", 26, "deneme3@hotmail.com"),
				new Customer("David", "Backhem", 30, "deneme4@gmail.com"),
				new Customer("George", "Bush", 42, "deneme5@hotmail.com")));
		return "Done";
	}

}