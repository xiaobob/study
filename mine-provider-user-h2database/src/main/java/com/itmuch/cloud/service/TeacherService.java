package com.itmuch.cloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itmuch.cloud.dao.TeacherDao;
import com.itmuch.cloud.domain.Teacher;

@Service
public class TeacherService {
	@Autowired
	private TeacherDao dao;
	
	public Teacher findOne(Long id) {
		return dao.findOne(id);
	}
	
	public List<Teacher> getAll() {
		 return dao.findAll();
	}
	

}
