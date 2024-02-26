package com.komal.springboot.restAPI.user;

import java.time.LocalDate;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class User {
	private Integer id;
	
	@Size(min=2, message="name should be more than 2 characters")
	private String name;
	@Past(message="Birth date should be in past")
	private LocalDate bdate;
	
	public User(Integer id, String name, LocalDate bdate) {
		super();
		this.id = id;
		this.name = name;
		this.bdate = bdate;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBdate() {
		return bdate;
	}

	public void setBdate(LocalDate bdate) {
		this.bdate = bdate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", bdate=" + bdate + "]";
	}
	
	
}
