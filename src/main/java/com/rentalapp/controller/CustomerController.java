package com.rentalapp.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentalapp.domain.service.CustomerService;
import com.rentalapp.model.CustomerModel;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("customer")
@RequiredArgsConstructor
public class CustomerController {

	private final CustomerService service;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public int insertCustomer(@RequestBody CustomerModel model) {
		return service.insert(model);
	}

	@GetMapping(value = "{id}")
	public CustomerModel selectOne(@PathVariable("id") String id) {
		return service.selectOne(Integer.parseInt(id));
	}

	@GetMapping
	public List<CustomerModel> selectAll() {
		return service.selectAll();
	}

	@PutMapping(value = "{id}")
	public int update(@PathVariable("id") int id, CustomerModel model) {
		model.setId(id);
		return service.update(model);
	}

	@DeleteMapping(value = "{id}")
	public int deleteOne(@PathVariable("id") int id) {
		return service.deleteOne(id);
	}

}
