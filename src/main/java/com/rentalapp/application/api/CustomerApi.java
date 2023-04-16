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

import com.rentalapp.application.model.CustomerRequest;
import com.rentalapp.application.model.CustomerResponse;

import io.swagger.v3.oas.annotations.Operation;

@RequestMapping("customers")
public interface CustomerApi {
	@Operation(summary = "顧客の登録")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	int insertCustomer(@RequestBody CustomerRequest request);

	@Operation(summary = "顧客の検索(ID検索)")
	@GetMapping(value = "{id}")
	CustomerResponse selectOne(@PathVariable("id") String id);

	@Operation(summary = "顧客の全件検索")
	@GetMapping
	List<CustomerResponse> selectAll();

	@Operation(summary = "顧客の更新")
	@PutMapping(value = "{id}")
	int update(@PathVariable("id") int id, CustomerRequest model);

	@Operation(summary = "顧客の削除")
	@DeleteMapping(value = "{id}")
	int deleteOne(@PathVariable("id") int id);
}
