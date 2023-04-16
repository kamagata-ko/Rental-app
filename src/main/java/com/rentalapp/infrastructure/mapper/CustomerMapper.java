package com.rentalapp.infrastructure.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.rentalapp.infrastructure.model.TCustomerModel;

/**
 * 顧客マッパーインターフェース。
 */
@Mapper
public interface CustomerMapper {
	/**
	 * 顧客情報登録処理。
	 *
	 * @param model 顧客テーブルモデル
	 * @return 登録件数
	 */
	int insert(TCustomerModel model);

	/**
	 * 顧客情報取得（１件）。
	 *
	 * @param id ID
	 * @return 顧客情報（１件）
	 */
	TCustomerModel selectOne(int id);

	/**
	 * 顧客情報取得（全件）。
	 *
	 * @return 顧客情報（全件）
	 */
	List<TCustomerModel> selectAll();

	/**
	 * 顧客情報更新処理。
	 *
	 * @param model 顧客テーブルモデル
	 * @return 更新件数
	 */
	int updateByPrimaryKeySelective(TCustomerModel model);

	/**
	 * 顧客情報削除処理（論理削除）。
	 *
	 * @param id ID
	 * @return 削除件数
	 */
	int deleteOne(int id);

}
