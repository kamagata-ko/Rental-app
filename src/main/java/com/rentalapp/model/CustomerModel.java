package com.rentalapp.model;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;

@Data
public class CustomerModel {

	String id;
	String password;
	String name;
	int sex;
	Date birthday;
	LocalDateTime registerDate;
	LocalDateTime updateDate;

}
