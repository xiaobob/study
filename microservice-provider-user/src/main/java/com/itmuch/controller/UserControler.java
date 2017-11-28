package com.itmuch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.enterty.User;

@RestController
public class UserControler {
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Value("${server.port}")
	private String port;
	
	@GetMapping("/{id}")
	public User findById(@PathVariable Long id){
		System.out.println();
		User user=new User();
		user.setId(1L);
		user.setAge(10);
		user.setName("stu");
		System.out.println("servce port-->"+port);
		return user;
	}
	/**
	* 本地服务实例的信息
	* @return
	*/
	@GetMapping("/instance-info")
	public ServiceInstance showInfo(){
		ServiceInstance serviceInstance=this.discoveryClient.getLocalServiceInstance();
		return serviceInstance;
	}
}
