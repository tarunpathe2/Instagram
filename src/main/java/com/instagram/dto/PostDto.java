package com.instagram.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.instagram.model.Tags;

public class PostDto {

	private Long id;

	private String name;

	private String description;

	private Long total_likes;

	@JsonIgnore
	private List<LikesDto> likes;

	private LocalDate createdDate;

	private Long userId;

	private Set<Tags> tag = new HashSet<>();

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getTotal_likes() {
		return total_likes;
	}

	public void setTotal_likes(Long total_likes) {
		this.total_likes = total_likes;
	}

	public List<LikesDto> getLikes() {
		return likes;
	}

	public void setLikes(List<LikesDto> likes) {
		this.likes = likes;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public Set<Tags> getTag() {
		return tag;
	}

	public void setTag(Set<Tags> tag) {
		this.tag = tag;
	}

}
