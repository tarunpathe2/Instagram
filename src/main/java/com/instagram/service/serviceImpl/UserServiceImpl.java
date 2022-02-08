package com.instagram.service.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instagram.dto.UserDto;
import com.instagram.exception.UserNotFoundException;
import com.instagram.model.User;
import com.instagram.repository.UserRepository;
import com.instagram.service.UserService;



@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserRepository repo;
	
	
	@Override
	public UserDto addUser(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		User savedUser = repo.save(user);
		UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);
		
		return savedUserDto;
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = repo.findAll();
		List<UserDto> userDto = users.stream().map(user -> modelMapper.map(user, UserDto.class))
				.collect(Collectors.toList());

		return userDto;

	}

	@Override
	public UserDto getUser(String email) {
		Optional<User> user = repo.findByEmail(email);
		UserDto userDto = null;
		if (!user.isPresent())
			throw new UserNotFoundException("Data Not found");

		userDto = modelMapper.map(user.get(), UserDto.class);
		return userDto;
	}

	@Override
	public UserDto getUserById(Long id) {
		Optional<User> userOptional = repo.findById(id);
		UserDto userDto = null;
		if (userOptional.isPresent()) {
			
			userDto = modelMapper.map(userOptional.get(), UserDto.class);
		}
		return userDto;
	}

	@Override
	public void deleteUser(Long id) {
		
		repo.deleteById(id);
	
			
	}
}
