package com.instagram.dto;

import com.instagram.model.Post;
import com.instagram.model.User;

public class LikesDto {

	private Long id;

	private User user;

	private Post post;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

}
