package com.itmuch.cloud.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itmuch.cloud.domain.Teacher;

public interface TeacherDao extends JpaRepository<Teacher, Serializable>{

}
