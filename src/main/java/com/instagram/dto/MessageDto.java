package com.instagram.dto;

import java.sql.Timestamp;

import com.instagram.model.User;

public class MessageDto {

	private Long id;

	private String Message;

	private User sender_user;

	private User reciever_user;

	private Timestamp time_date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public User getSender_user() {
		return sender_user;
	}

	public void setSender_user(User sender_user) {
		this.sender_user = sender_user;
	}

	public User getReciever_user() {
		return reciever_user;
	}

	public void setReciever_user(User reciever_user) {
		this.reciever_user = reciever_user;
	}

	public Timestamp getTime_date() {
		return time_date;
	}

	public void setTime_date(Timestamp time_date) {
		this.time_date = time_date;
	}

}
