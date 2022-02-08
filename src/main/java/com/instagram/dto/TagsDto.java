package com.instagram.dto;

import java.util.HashSet;
import java.util.Set;

import com.instagram.model.Post;

public class TagsDto {

	private Long id;
	
	private String tag;
	
	private Set<Post> post = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Set<Post> getPost() {
		return post;
	}

	public void setPost(Set<Post> post) {
		this.post = post;
	}
	
	
}
