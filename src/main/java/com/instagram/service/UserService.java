package com.instagram.service;

import java.util.List;

import com.instagram.dto.UserDto;

public interface UserService {

	public UserDto addUser(UserDto userDto);
	public List<UserDto> getAllUsers();
	public UserDto getUser(String email);
	public UserDto getUserById(Long id);
	public void deleteUser(Long id);
}
