package com.rentalapp.application.api;

import com.rentalapp.application.model.CustomerCreateRequest;
import com.rentalapp.application.model.CustomerResponse;
import com.rentalapp.application.model.CustomerUpdateRequest;
import com.rentalapp.application.model.CustomersResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
     * 顧客情報取得処理.
     *
     * @param limit  取得件数（指定がない場合は10件）
     * @param offset 取得開始位置（指定がない場合は0から）
     * @param sort   ソート条件（指定がない場合はidの昇順）
     * @return 顧客情報
     */
    @Operation(summary = "顧客の複数件検索")
    @GetMapping
    CustomersResponse select(
            @RequestParam(name = "limit", required = false, defaultValue = "10") Integer limit,
            @RequestParam(name = "offset", required = false, defaultValue = "0") Integer offset,
            @RequestParam(name = "sort", required = false, defaultValue = "id asc") String sort);

    /**
     * 顧客情報更新処理.
     *
     * @param id  ID
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
