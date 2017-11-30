package study.bobo.controllrt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import study.bobo.domain.Student;
import study.bobo.service.IStudentService;

@RestController
public class StudentController {
	
	@Autowired
	private IStudentService service;
	
	@GetMapping("/{id}")
	public Student getById(@PathVariable Long id){
		return service.getOne(id);
	}
	
	@GetMapping("/all")
	public List<Student> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/add")
	public int add(Student student){
		student.setName("xiaobobo");
		student.setAge(23);
		return service.insertStudent(student);
	}
}
