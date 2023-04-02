package com.rentalapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentalapp.domain.service.CustomerService;
import com.rentalapp.model.CustomerModel;

@RestController
@RequestMapping("api")
public class CustomerController {

	@Autowired
	private CustomerService service;

	@PostMapping(value = "/insertcustomer", consumes = MediaType.APPLICATION_JSON_VALUE)
	public int insertCustomer(@RequestBody CustomerModel model) {
		return service.insertCustomer(model);
	}

	@GetMapping(value = "/selectcustomer/{id}")
	public CustomerModel selectOne(@PathVariable("id") String id) {
		return service.selectOne(id);
	}

	@GetMapping(value = "/selectallcustomer")
	public List<CustomerModel> selectAll() {
		return service.selectAll();
	}

}
