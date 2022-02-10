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

import com.instagram.dto.LikesDto;
import com.instagram.dto.PostDto;
import com.instagram.service.LikeService;

@RestController
@RequestMapping("/instagram/post")
public class LikesController {
	
	@Autowired
	private LikeService likeService;
	
	@PostMapping("/like")
	public ResponseEntity<String> like(@RequestBody LikesDto likeDto) {
		return new ResponseEntity<String>(likeService.like(likeDto), HttpStatus.OK);
	}

	@PostMapping("/unlike")
	public ResponseEntity<String> unlike(@RequestBody LikesDto likeDto) {
		return new ResponseEntity<String>(likeService.unLike(likeDto), HttpStatus.OK);
	}
	
	@GetMapping("/Alllikes")
	public ResponseEntity<List<LikesDto>> getAllPost() {
		return new ResponseEntity<List<LikesDto>>(likeService.getAllLikes(), HttpStatus.OK);
	}
}
