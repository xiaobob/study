package com.itmuch.cloud.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.domain.Teacher;
import com.itmuch.cloud.service.TeacherService;

@RestController
public class TeacherControler {
	@Autowired
	private TeacherService service;
	
	@GetMapping("/{id}")
	public Teacher getOne(@PathVariable Long id){
		return service.findOne(id);
	}
	
	@GetMapping("/all")
	public List<Teacher> getAll(){
		return service.getAll();
	}
}
