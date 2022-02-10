package com.instagram.service;

import com.instagram.dto.CommentDto;

public interface CommentService {

	public String addComments(CommentDto commentsDto);
	public void deleteComment(Long id);
}
