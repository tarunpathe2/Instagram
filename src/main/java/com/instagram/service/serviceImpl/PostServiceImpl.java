package com.instagram.service.serviceImpl;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instagram.dto.PostDto;
import com.instagram.exception.UserNotFoundException;
import com.instagram.model.Post;
import com.instagram.model.Tags;
import com.instagram.repository.PostRepository;
import com.instagram.repository.UserRepository;
import com.instagram.service.PostService;


@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;


	private void userExist(long id) {
		if (!userRepository.existsById(id)) {
			throw new UserNotFoundException("User Not Found");
		}
	}
	
	@Override
	public PostDto addPost(PostDto postDto) {
		userExist(postDto.getUserId());
		var date = LocalDate.now();
		Post post = modelMapper.map(postDto, Post.class);
		post.setUser(userRepository.findById(postDto.getUserId()).get());
		post.setCreatedDate(date);
		List<Tags> tags = new ArrayList<>();
		postDto.getTag().stream().forEach(e -> {
			Tags tag = new Tags();
			tag.setTag(e.getTag());
			tags.add(tag);
		});
		postRepository.save(post);
		return modelMapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getAllPosts() {
		List<Post> posts = postRepository.findAll();
		List<PostDto> postDto = posts.stream().map(post -> modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());

		return postDto;
	}

	@Override
	public PostDto getPostById(Long id) {
		Optional<Post> postOptional = postRepository.findById(id);
		PostDto postDto = null;
		if (postOptional.isPresent()) {

			postDto = modelMapper.map(postOptional.get(), PostDto.class);
		}
		return postDto;
	}

	@Override
	public void deleteUser(Long id) {
		postRepository.deleteById(id);

	}

}
