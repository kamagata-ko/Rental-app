package com.rentalapp.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class CustomerModel {
    private String id;
    private String password;
    private String name;
    private int sex;
    private Date birthday;
    private LocalDateTime registerDate;
    private LocalDateTime updateDate;
}
