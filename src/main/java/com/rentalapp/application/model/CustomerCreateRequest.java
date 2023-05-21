package com.rentalapp.application.model;

import java.time.LocalDate;

/**
 * 顧客APIリクエスト（データ登録用）.
 */
public record CustomerCreateRequest(
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
        String telephoneNumber
) {
}
