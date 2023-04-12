package com.rentalapp.application.model;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;

@Data
public class CustomerResponse {
	private int id;
	private String password;
	private String name;
	private int sex;
	private Date birthday;
	private LocalDateTime registerDate;
	private LocalDateTime updateDate;
	private int deleteFlg;
}
