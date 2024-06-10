package com.springboilerplate.app.user.api.controllers;

import java.util.LinkedList;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import com.springboilerplate.app.user.api.dto.CreateUserDto;
import com.springboilerplate.app.user.operations.UserOperation;
import com.springboilerplate.domain.entities.UserEntity;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserOperation userOperation;

	@PostMapping
	public @ResponseBody ResponseEntity<UserEntity> create(
			@RequestBody @Validated CreateUserDto data) {
		try {
			UserEntity user = this.userOperation.create(data);

			if (user == null || user.getId() == null) {
				return ResponseEntity.notFound().build();
			}

			return ResponseEntity.ok(user);
		} catch (Exception exception) {
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping("/")
	public @ResponseBody ResponseEntity<LinkedList<UserEntity>> list(
			@RequestParam(value = "startDate", defaultValue = "") long startDate,
			@RequestParam(value = "endDate", defaultValue = "") long endDate) {
		if (startDate != 0 && endDate != 0)
			try {
				LinkedList<UserEntity> users = new LinkedList<UserEntity>();
				users.add(new UserEntity(null));

				return ResponseEntity.ok(users);
			} catch (Exception exception) {
				return ResponseEntity.badRequest().build();
			}
		return ResponseEntity.notFound().build();
	}
}
