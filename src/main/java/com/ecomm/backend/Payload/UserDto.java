package com.ecomm.backend.Payload;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

	private int userId;

	private String name;

	private String email;

	private String password;

	private String address;

	private String gender;

	private String phone;

	private Date date;
	private boolean active;

}
