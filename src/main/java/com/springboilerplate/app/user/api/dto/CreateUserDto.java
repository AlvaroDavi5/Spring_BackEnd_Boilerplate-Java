package com.springboilerplate.app.user.api.dto;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

public record CreateUserDto(
		@NotBlank String fullName) {
}
