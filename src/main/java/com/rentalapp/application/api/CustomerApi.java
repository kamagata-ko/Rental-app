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

import com.rentalapp.application.model.CustomerCreateRequest;
import com.rentalapp.application.model.CustomerResponse;
import com.rentalapp.application.model.CustomerUpdateRequest;

import io.swagger.v3.oas.annotations.Operation;

/**
 * 顧客API.
 */
@RequestMapping("customers")
public interface CustomerApi {

	/**
	 * 顧客情報登録処理.
	 *
	 * @param request 顧客情報リクエスト
	 * @return 登録件数.
	 */
	@Operation(summary = "顧客の登録")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	int insertCustomer(@RequestBody CustomerCreateRequest request);

	/**
	 * 顧客情報取得（１件）.
	 *
	 * @param id ID
	 * @return 顧客情報（１件）
	 */
	@Operation(summary = "顧客の検索(ID検索)")
	@GetMapping(value = "{id}")
	CustomerResponse selectOne(@PathVariable("id") String id);

	/**
	 * 顧客情報取得処理（全件）.
	 *
	 * @return 顧客情報（全件）
	 */
	@Operation(summary = "顧客の全件検索")
	@GetMapping
	List<CustomerResponse> selectAll();

	/**
	 * 顧客情報更新処理.
	 *
	 * @param id ID
	 * @param req リクエスト
	 * @return 更新件数
	 */
	@Operation(summary = "顧客の更新")
	@PutMapping(value = "{id}")
	int update(@PathVariable("id") int id, @RequestBody CustomerUpdateRequest req);

	/**
	 * 顧客情報削除処理（論理削除）.
	 *
	 * @param id ID
	 * @return 削除件数
	 */
	@Operation(summary = "顧客の削除")
	@DeleteMapping(value = "{id}")
	int deleteOne(@PathVariable("id") int id);
}
