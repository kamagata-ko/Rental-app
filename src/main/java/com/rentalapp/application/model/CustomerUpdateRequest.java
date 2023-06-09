package com.rentalapp.application.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
        LocalDate birthday,
        /* メールアドレス */
        String mailAddress,
        /* 電話番号 */
        String telephoneNumber,
        /* 登録日時 */
        LocalDateTime registerDate,
        /* 更新日時 */
        LocalDateTime updateDate,
        /* 削除フラグ */
        int deleteFlg) {
}
