package com.instagram.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.instagram.model.User;

public class FollowersDto {

	private Long follower;
	
	@JsonIgnore
	private List<User> user;

	public Long getFollower() {
		return follower;
	}

	public void setFollower(Long follower) {
		this.follower = follower;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}
	
	
}
