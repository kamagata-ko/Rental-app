package com.rentalapp.infrastructure.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TCustomerModel {
    /* ID */
    private int id;
    /* パスワード */
    private String password;
    /* 名前 */
    private String name;
    /* 性別 */
    private int gender;
    /* 生年月日 */
    private LocalDate birthday;
    /* メールアドレス */
    private String mailAddress;
    /* 電話番号 */
    private String telephoneNumber;
    /* 登録日時 */
    private LocalDateTime registerDate;
    /* 更新日時 */
    private LocalDateTime updateDate;
    /* 削除フラグ */
    private int deleteFlg;
}
