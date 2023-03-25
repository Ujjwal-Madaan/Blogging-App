package com.ujjwal.blog.services.Impl;

import com.ujjwal.blog.entities.User;
import com.ujjwal.blog.exceptions.ResourceNotFoundException;
import com.ujjwal.blog.payloads.UserDto;
import com.ujjwal.blog.repositories.UserRepo;
import com.ujjwal.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		User savedUser = userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.dtoToUser(userDto);

		User getUser = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

		getUser.setAbout(user.getAbout());
		getUser.setName(user.getName());
		getUser.setEmail(user.getEmail());
		getUser.setPassword(user.getPassword());

		User updatedUser = userRepo.save(getUser);

		return this.userToDto(updatedUser);

	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));

		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = userRepo.findAll();

		List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());

		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		userRepo.deleteById(userId);
	}

	private User dtoToUser(UserDto userDto) {
		return User.builder()
				.id(userDto.getId())
				.name(userDto.getName())
				.about(userDto.getAbout())
				.email(userDto.getEmail())
				.password(userDto.getPassword())
				.build();
	}

	private UserDto userToDto(User user) {
		return UserDto.builder()
				.id(user.getId())
				.name(user.getName())
				.about(user.getAbout())
				.email(user.getEmail())
				.password(user.getPassword())
				.build();
	}
}
