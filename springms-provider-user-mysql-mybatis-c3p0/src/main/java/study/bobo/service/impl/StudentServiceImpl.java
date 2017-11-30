package study.bobo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.bobo.domain.Student;
import study.bobo.mapper.StudentMapper;
import study.bobo.service.IStudentService;

@Service
@Transactional
public class StudentServiceImpl implements IStudentService{

	@Autowired
	private StudentMapper mapper;
	
	@Override
	public List<Student> getAll() {
		return mapper.getAll();
	}

	@Override
	public Student getOne(Long id) {
		return mapper.getOne(id);
	}

	@Override
	public int insertStudent(Student student) {
		return  mapper.insertStudent(student);
	}

}
