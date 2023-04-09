package com.rentalapp.infrastructure.model;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;

@Data
public class TCustomerModel {
	private int id;
	private String password;
	private String name;
	private int sex;
	private Date birthday;
	private LocalDateTime registerDate;
	private LocalDateTime updateDate;
	private int deleteFlg;
}
