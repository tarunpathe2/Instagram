package com.instagram.service.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instagram.dto.CommentDto;
import com.instagram.exception.PostNotFoundException;
import com.instagram.model.Comment;
import com.instagram.repository.CommentRepository;
import com.instagram.repository.PostRepository;
import com.instagram.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private CommentRepository commentRepo;
	
	@Override
	public String addComments(CommentDto commentsDto) {
		if (!postRepo.existsById(commentsDto.getPostId())) {
			throw new PostNotFoundException("Post does not exist");
		}
		Comment comment = modelMapper.map(commentsDto, Comment.class);
		comment.setPost(postRepo.findById(commentsDto.getPostId()).get());
		comment = commentRepo.save(comment);
		return "Comment Saved";
		
	}
	
	@Override
	public void deleteComment(Long id)
	{
		commentRepo.deleteById(id);
	}
	
}
