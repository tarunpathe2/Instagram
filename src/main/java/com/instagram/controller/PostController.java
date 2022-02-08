package com.instagram.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.instagram.dto.PostDto;
import com.instagram.service.PostService;

@RestController
@RequestMapping("/instagram/post")
public class PostController {

	@Autowired
	private PostService postService;

	@GetMapping("/{id}")
	public ResponseEntity<PostDto> getPost(@PathVariable Long id) {
		return new ResponseEntity<PostDto>(postService.getPostById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<PostDto> addPost(@RequestBody PostDto postDto) {
		return new ResponseEntity<PostDto>(postService.addPost(postDto), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<PostDto>> getAllPost() {
		return new ResponseEntity<List<PostDto>>(postService.getAllPosts(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<PostDto> deleteUser(@PathVariable Long id) {
		postService.deleteUser(id);
		return new ResponseEntity<PostDto>(HttpStatus.OK);
	}
}
