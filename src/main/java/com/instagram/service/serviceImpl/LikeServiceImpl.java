package com.instagram.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instagram.dto.LikesDto;
import com.instagram.dto.PostDto;
import com.instagram.exception.PostNotFoundException;
import com.instagram.exception.UserNotFoundException;
import com.instagram.model.Likes;
import com.instagram.model.Post;
import com.instagram.repository.LikesRepository;
import com.instagram.repository.PostRepository;
import com.instagram.repository.UserRepository;
import com.instagram.service.LikeService;

@Service
public class LikeServiceImpl  implements LikeService{
	
	@Autowired
	private LikesRepository likesRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PostRepository postRepository;

	@Autowired
	private UserRepository userRepository;

	private void ifUserExist(Long id) {
		if (!userRepository.existsById(userRepository.findById(id).get().getId())) {
			throw new UserNotFoundException("User Not found");
		}
	}

	private void ifPostExist(Long id) {
		if (!postRepository.existsById(id)) {
			throw new PostNotFoundException("Post Not found");
		}
	}

	@Override
	public String like(LikesDto likeDto) {
		ifUserExist(likeDto.getUserId());
		ifPostExist(likeDto.getPostId());
		Likes likes = modelMapper.map(likeDto, Likes.class);
		likesRepository.save(likes);
		Post post = postRepository.findById(likeDto.getPostId()).get();
		post.setTotal_likes(likesRepository.countByPostId(likeDto.getPostId()));
		postRepository.save(post);
		return "Liked successfully";
	}

	@Override
	public String unLike(LikesDto likeDto) {
		ifUserExist(likeDto.getUserId());
		ifPostExist(likeDto.getPostId());
		Likes likes = modelMapper.map(likeDto, Likes.class);
		likesRepository.delete(likes);
		Post post = postRepository.findById(likeDto.getPostId()).get();
		post.setTotal_likes(likesRepository.countByPostId(likeDto.getPostId()));
		postRepository.save(post);
		return "Unliked successfully";
	}
	
	@Override
	public List<LikesDto> getAllLikes() {
		List<Likes> likes = likesRepository.findAll();
		List<LikesDto> postDto = likes.stream().map(post -> modelMapper.map(post, LikesDto.class))
				.collect(Collectors.toList());

		return postDto;
	}

}
