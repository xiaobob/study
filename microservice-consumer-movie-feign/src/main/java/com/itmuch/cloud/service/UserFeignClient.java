package com.itmuch.cloud.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itmuch.cloud.domain.User;
import com.itmuch.cloud.service.UserFeignClient.HystrixClientFallBack;

@FeignClient(name = "microservice-provider-user",fallback=HystrixClientFallBack.class)
public interface UserFeignClient {
	@RequestMapping("/{id}")
	public User findByIdFeign(@RequestParam("id") Long id);
	
	@Component
	static class HystrixClientFallBack implements UserFeignClient{
		
		private static final Logger LOGGER=LoggerFactory.getLogger(HystrixClientFallBack.class);

		@Override
		public User findByIdFeign(Long id) {
			HystrixClientFallBack.LOGGER.info("异常发生，进入异常方法，接收的参数id={}"+id);
			User user=new User();
			user.setId(-1L);
			user.setAge(0);
			user.setName("default name");
			return user;
		}
		
	}

}
