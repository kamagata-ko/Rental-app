package com.rentalapp.application.model;


import java.util.Date;

public record CustomerCreateRequest(
        /* パスワード */
        String password,
        /* 名前 */
        String name,
        /* 性別 */
        int sex,
        /* 生年月日 */
        Date birthday
) {
}
