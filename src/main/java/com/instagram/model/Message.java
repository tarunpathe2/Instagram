package com.instagram.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private User sender_user;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private User reciever_user;

	private String message;

	private Timestamp time_date;

	public Message() {
		super();
	}

	public Message(Long id, User sender_user, User reciever_user, String message, Timestamp time_date) {
		super();
		this.id = id;
		this.sender_user = sender_user;
		this.reciever_user = reciever_user;
		this.message = message;
		this.time_date = time_date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Timestamp getTime_date() {
		return time_date;
	}

	public void setTime_date(Timestamp time_date) {
		this.time_date = time_date;
	}

}
