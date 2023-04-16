package com.rentalapp.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
public class CustomerModel {
    private int id;
    private String password;
    private String name;
    private int sex;
    private Date birthday;
    private LocalDateTime registerDate;
    private LocalDateTime updateDate;
    private int deleteFlg;
}
