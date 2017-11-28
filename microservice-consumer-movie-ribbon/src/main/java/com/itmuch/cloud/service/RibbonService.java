package com.itmuch.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.itmuch.cloud.domain.User;

@Service
public class RibbonService {
	@Autowired
	private RestTemplate restTemplate;
	
	public User findById(Long id){
		return this.restTemplate.getForObject("http://microservice-provider-user/" + id, User.class);
	}
}
