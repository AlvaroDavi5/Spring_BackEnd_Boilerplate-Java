package com.springboilerplate.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DefaultController {
	@GetMapping("/healthcheck")
	public String healthCheck() {
		return "{ \"status\": \"OK\" }";
	}
}
