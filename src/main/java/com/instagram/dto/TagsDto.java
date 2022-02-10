package com.instagram.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class TagsDto {

	private Long id;

	private String tag;

	@JsonIgnore
	private Long Post;

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

	public Long getPost() {
		return Post;
	}

	public void setPost(Long post) {
		Post = post;
	}

}
