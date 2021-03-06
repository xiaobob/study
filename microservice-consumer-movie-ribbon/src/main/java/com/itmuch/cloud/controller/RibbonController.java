package com.itmuch.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.domain.User;
import com.itmuch.cloud.service.RibbonService;

@RestController
public class RibbonController {

	@Autowired
	RibbonService ribbonService;

	@GetMapping("/ribbon/{id}")
	public User findById(@PathVariable Long id) {
		return this.ribbonService.findById(id);
	}
}
