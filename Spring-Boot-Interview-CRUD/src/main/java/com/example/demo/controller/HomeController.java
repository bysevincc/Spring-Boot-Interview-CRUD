package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import com.example.demo.service.CustomerServiceImp;
import com.example.demo.dao.CustomerCrudRepository;

@RestController
public class HomeController {

	@Autowired
	CustomerCrudRepository repository;

	@Autowired
	CustomerService customerService;

	// index jsp sayfasi mapping
	@GetMapping("/")
	public ModelAndView getHome() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		mav.addObject("message", "this is an index jsp file called index.jsp");
		return mav;
	}

	// insert data
	@PostMapping("/InsertCustomer")
	public ModelAndView InsertCustomer(@Valid @ModelAttribute("customer") Customer customer) {
		customerService.saveCustomer(customer);
		return StaticCustomersFile("customers", "İnsert Customer");
	}

	// jsp sayfasında eklediklerimizin gösterilmesi
	@GetMapping("/insertCustomerPanel")
	public ModelAndView insertCustomerPanel() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("title", " - Customers İnsert Panel - ");
		mav.addObject("message", "this is an customer İnsert Panel");
		mav.addObject("customer", new Customer());
		mav.setViewName("insertCustomer");
		return mav;
	}

	// update data
	@PostMapping("/UpdateCustomer")
	public ModelAndView UpdateCustomer(@Valid @ModelAttribute("customer") Customer customer) {
		customerService.saveCustomer(customer);
		return StaticCustomersFile("customers", "Update Customer");
	}

	// jsp sayfasında eklediklerimizin gösterilmesi
	@GetMapping("/updateCustomerPanel/{id}")
	public ModelAndView updateCustomerPanel(@PathVariable("id") long id) {

		Customer customer = customerService.findCustomerById(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("title", " - Customers Update Panel - ");
		mav.addObject("message", "this is an customer Update Panel");
		mav.addObject("customer", customer);
		mav.setViewName("updateCustomer");
		return mav;
	}

	// tum dataların gosterilmesi
	@GetMapping("/customers")
	public ModelAndView getCustomersPage() {
		List<Customer> customers = customerService.findallCustomers();
		ModelAndView mav = new ModelAndView();
		mav.addObject("title", "Customers File");
		mav.addObject("customers", customers);
		mav.addObject("message", "this is an customer jsp file called customers.jsp");
		mav.setViewName("customers");
		return mav;
	}

	// tek customer gosterilmesi postman de de denendi
	@GetMapping("/viewCustomer/{id}")
	public ModelAndView viewCustomer(@PathVariable("id") long id) {

		Customer customer = customerService.findCustomerById(id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("viewCustomer");
		mav.addObject("title", "Hoşgeldiniz " + customer.firstName + " " + customer.lastName);
		mav.addObject("customer", customer);

		mav.addObject("message", "Details of Customer");
		return mav;
	}

	// datayı sil
	@GetMapping("/deleteCustomer/{id}")
	public ModelAndView deleteCustomer(@PathVariable("id") long id) {
		customerService.DeleteCustomerById(id);

		return StaticCustomersFile("customers", "delete data");
	}

	// coklu data kaydedilmesi
	@GetMapping("/saveAll")
	public ModelAndView SaveAll() {
		// tekli data kaydedilmesi
		customerService.saveCustomer(new Customer("Hasan", "Erbas", 23, "hasanerbas@hotmail.com"));

		// listeden kaydedilmesi
		repository.saveAll(Arrays.asList(new Customer("Recep", "Dag", 85, "recepdag@gmail.com"),
				new Customer("Fatih", "Yardım", 51, "deneme2@yahoo.com"),
				new Customer("Adem", "Yılmaz", 26, "deneme3@hotmail.com"),
				new Customer("David", "Backhem", 30, "deneme4@gmail.com"),
				new Customer("George", "Bush", 42, "deneme5@hotmail.com")));
		return StaticCustomersFile("customers", "İnsert multiple sample Customers");
	}

	public ModelAndView StaticCustomersFile(String viewname, String message) {
		List<Customer> customers = customerService.findallCustomers();
		ModelAndView mav = new ModelAndView();
		mav.addObject("title", "Customers File");
		mav.addObject("customers", customers);
		mav.addObject("message", message);
		mav.setViewName(viewname);
		return mav;
	}

}
