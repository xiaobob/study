package study.bobo.service;

import java.util.List;


import study.bobo.domain.Student;

public interface IStudentService {
	List<Student> getAll();
	
	Student getOne(Long id);
	
    int insertStudent(Student student);
}
