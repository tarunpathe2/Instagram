package com.instagram.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.instagram.model.Follower;
import com.instagram.model.Post;

public class UserDto {

	private Long id;

	private String name;

	private String email;

	private String password;

	@JsonIgnore
	private Set<Follower> follower = new HashSet<>();

	@JsonIgnore
	private List<PostDto> post;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Follower> getFollower() {
		return follower;
	}

	public void setFollower(Set<Follower> follower) {
		this.follower = follower;
	}

	public List<PostDto> getPost() {
		return post;
	}

	public void setPost(List<PostDto> post) {
		this.post = post;
	}

}
