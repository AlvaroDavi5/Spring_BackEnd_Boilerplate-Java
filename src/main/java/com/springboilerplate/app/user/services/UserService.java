package com.springboilerplate.app.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboilerplate.core.infra.database.repositories.UserRepository;
import com.springboilerplate.domain.entities.UserEntity;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	@Transactional
	public UserEntity create(UserEntity user) {
		try {
			user.fromModel(this.userRepository.save(user.toModel()));

			if (user.getId() == null) {
				return null;
			}

			return user;
		} catch (Exception exception) {
			return null;
		}
	}
}
