package com.rentalapp.controller;

import com.rentalapp.domain.service.CustomerService;
import com.rentalapp.model.CustomerModel;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @Operation(summary = "書籍の登録")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public int insertCustomer(@RequestBody CustomerModel model) {
        return service.insert(model);
    }

    @Operation(summary = "書籍の検索(ID検索)")
    @GetMapping(value = "{id}")
    public CustomerModel selectOne(@PathVariable("id") String id) {
        return service.selectOne(Integer.parseInt(id));
    }

    @Operation(summary = "書籍の全件検索")
    @GetMapping
    public List<CustomerModel> selectAll() {
        return service.selectAll();
    }

    @Operation(summary = "書籍の更新")
    @PutMapping(value = "{id}")
    public int update(@PathVariable("id") int id, CustomerModel model) {
        model.setId(id);
        return service.update(model);
    }

    @Operation(summary = "書籍の削除")
    @DeleteMapping(value = "{id}")
    public int deleteOne(@PathVariable("id") int id) {
        return service.deleteOne(id);
    }

}
