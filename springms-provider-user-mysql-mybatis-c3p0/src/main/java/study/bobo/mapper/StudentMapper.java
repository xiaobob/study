package study.bobo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import study.bobo.domain.Student;

public interface StudentMapper{
	@Select("select * from student")
	List<Student> getAll();
	
	@Select("select * from student where id= #{id}")
	Student getOne(Long id);
	
	@Insert("INSERT INTO student(name, age) VALUES( #{name}, #{age})")
    int insertStudent(Student student);
	
}
