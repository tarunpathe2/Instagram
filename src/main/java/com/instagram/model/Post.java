package com.instagram.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String description;

	private Long total_likes;

	private LocalDate createdDate;

	@ManyToOne
	@JoinColumn(name = "users_id")
	private User user;

	@ManyToMany
	@JoinTable(name = "post_tag", joinColumns = { @JoinColumn(name = "post_id") }, inverseJoinColumns = {
			@JoinColumn(name = "tag_id") })
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

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public User getUser() {
		return user;
	}

	public Set<Tags> getTag() {
		return tag;
	}

	public void setTag(Set<Tags> tag) {
		this.tag = tag;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post(Long id, String name, String description, Long total_likes, LocalDate createdDate, User user,
			Set<Tags> tag) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.total_likes = total_likes;
		this.createdDate = createdDate;
		this.user = user;
		this.tag = tag;
	}

	public Post() {
		super();
	}

}
