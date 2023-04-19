package com.rentalapp.application.model;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 顧客APIリクエスト.
 */
public record CustomerUpdateRequest(
		/* ID */
		int id,
		/* パスワード */
		String password,
		/* 名前 */
		String name,
		/* 性別 */
		int gender,
		/* 生年月日 */
		Date birthday,
		/* 登録日時 */
		LocalDateTime registerDate,
		/* 更新日時 */
		LocalDateTime updateDate,
		/* 削除フラグ */
		int deleteFlg) {
}
