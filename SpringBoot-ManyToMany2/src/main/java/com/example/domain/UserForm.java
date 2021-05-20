package com.example.domain;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class UserForm {

	@NotEmpty
	private String name;
}
