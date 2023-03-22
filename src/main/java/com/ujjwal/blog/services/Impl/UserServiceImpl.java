package com.ujjwal.blog.services.Impl;

import com.ujjwal.blog.payloads.UserDto;
import com.ujjwal.blog.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl {
	@Autowired
	private UserRepo userRepo;

	public UserDto createUser(UserDto user) {
		return null;
	}
	public UserDto updateUser(UserDto user, Integer userId) {
		return null;
	}
	public UserDto getUserById(Integer userId) {
		return null;
	}
	public List<UserDto> getAllUsers() {
		return null;
	}
	public void deleteUser(Integer userId) {

	}
}
