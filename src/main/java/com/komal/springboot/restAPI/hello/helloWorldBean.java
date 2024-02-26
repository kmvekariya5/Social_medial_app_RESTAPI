package com.komal.springboot.restAPI.hello;

public class helloWorldBean {

	private String message;

	public helloWorldBean(String string) {
		this.message = string;
	}

	@Override
	public String toString() {
		return "helloWorldBean [message=" + message + "]";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
