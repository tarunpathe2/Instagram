package com.instagram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.instagram.dto.CommentDto;
import com.instagram.service.CommentService;


@RestController
@RequestMapping("/instagram/post")
public class CommentsController {

	@Autowired
	private CommentService commentService;
	

	@PostMapping("/comments")
	public ResponseEntity<String> addComment(@RequestBody CommentDto commentDto)
	{
		return new ResponseEntity<String> (commentService.addComments(commentDto),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-comments/{id}")
	public ResponseEntity deleteComment(@PathVariable Long id)
	{
		commentService.deleteComment(id);
		return new ResponseEntity<> (HttpStatus.OK);
	}
}
