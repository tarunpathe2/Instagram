package com.instagram.service;

import java.util.List;

import com.instagram.dto.PostDto;

public interface PostService {

	public PostDto addPost(PostDto postDto);
	public List<PostDto> getAllPosts();
	public PostDto getPostById(Long id);
	public void deleteUser(Long id);
	
}
