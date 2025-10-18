package com.adtech.springboilerplate.app.user.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adtech.springboilerplate.app.user.api.dto.CreateUserDto;
import com.adtech.springboilerplate.app.user.services.UserService;
import com.adtech.springboilerplate.domain.entities.UserEntity;

@Component
public class CreateUserUseCase {
	@Autowired
	private UserService userService;

	public UserEntity execute(CreateUserDto userData) {
		return this.userService.create(new UserEntity(userData));
	}
}
