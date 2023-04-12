package com.rentalapp.application.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rentalapp.model.CustomerModel;

import io.swagger.v3.oas.annotations.Operation;

@RequestMapping("customer")
public interface CustomerApi {
	@Operation(summary = "書籍の登録")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	int insertCustomer(@RequestBody CustomerModel model);

	@Operation(summary = "書籍の検索(ID検索)")
	@GetMapping(value = "{id}")
	CustomerModel selectOne(@PathVariable("id") String id);

	@Operation(summary = "書籍の全件検索")
	@GetMapping
	List<CustomerModel> selectAll();

	@Operation(summary = "書籍の更新")
	@PutMapping(value = "{id}")
	int update(@PathVariable("id") int id, CustomerModel model);

	@Operation(summary = "書籍の削除")
	@DeleteMapping(value = "{id}")
	int deleteOne(@PathVariable("id") int id);
}
