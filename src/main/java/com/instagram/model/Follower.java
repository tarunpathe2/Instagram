package com.instagram.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Follower {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToMany(mappedBy = "follower", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<User> user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public Follower(Long id, List<User> user) {
		super();
		this.id = id;
		this.user = user;
	}

	public Follower() {
		super();
	}

}
