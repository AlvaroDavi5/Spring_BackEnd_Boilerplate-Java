package com.springboilerplate.app.user.operations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboilerplate.app.user.api.dto.CreateUserDto;
import com.springboilerplate.app.user.services.UserService;
import com.springboilerplate.domain.entities.UserEntity;

@Component
public class UserOperation {
	@Autowired
	private UserService userService;

	public UserEntity create(CreateUserDto userData) {
		return this.userService.create(new UserEntity(userData));
	}
}
