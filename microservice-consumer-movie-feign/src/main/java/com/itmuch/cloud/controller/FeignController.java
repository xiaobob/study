package com.itmuch.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.domain.User;
import com.itmuch.cloud.service.UserFeignClient;

@RestController
public class FeignController {
	@Autowired
	UserFeignClient client;

	@GetMapping("/feign/{id}")
	public User findByIdFeign(@PathVariable Long id) {
		User user = this.client.findByIdFeign(id);
		return user;
	}
}
