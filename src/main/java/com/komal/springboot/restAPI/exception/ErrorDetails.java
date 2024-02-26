package com.komal.springboot.restAPI.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorDetails {
	private LocalDateTime timestamp;
	private String Msg;
	private String Details;
	public ErrorDetails(LocalDateTime timestamp, String msg, String details) {
		super();
		this.timestamp = timestamp;
		Msg = msg;
		Details = details;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getMsg() {
		return Msg;
	}
	public void setMsg(String msg) {
		Msg = msg;
	}
	public String getDetails() {
		return Details;
	}
	public void setDetails(String details) {
		Details = details;
	}
	
	
}
