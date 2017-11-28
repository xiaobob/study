package com.itmuch.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.domain.User;
import com.itmuch.cloud.service.RibbonHystrixService;

@RestController
public class RibbonHystrixController {
	@Autowired
	RibbonHystrixService service;
	
	@GetMapping("/hystrix/{id}")
	public User findById(@PathVariable Long id){
		return service.findById(id);
	}
}
