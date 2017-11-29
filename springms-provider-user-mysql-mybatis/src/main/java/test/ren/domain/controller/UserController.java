package test.ren.domain.controller;

import java.util.List;

import javax.ws.rs.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import test.ren.domain.User;
import test.ren.service.IUserService;

@RestController
public class UserController {
	@Autowired
	private IUserService userService;
	
	@GetMapping("/{id}")
	public User findUserById(@PathVariable("id") Long id){
		return userService.findUserById(id);
	}
	
	@GetMapping("/all")
	public List<User> findAllUsers(){
		return userService.findAllUsers();
	}
	
	@GetMapping("insert")
	public int insertUser(){
		User user=new User();
		user.setAge(20);
		user.setBalance("test");
		user.setName("test");
		user.setUsername("testUserName");
		return userService.insertUser(user);
	}
}
