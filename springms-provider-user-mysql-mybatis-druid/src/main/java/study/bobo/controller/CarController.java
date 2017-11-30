package study.bobo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import study.bobo.domain.Car;
import study.bobo.service.ICarService;

@RestController
public class CarController {
	@Autowired
	private ICarService service;
	
	@GetMapping("/all")
	public List<Car> getAll(){
		return service.getAll();
	}
	@GetMapping("/{id}")
	public Car getOne(@PathVariable("id") Long id){
		return service.getOne(id);
	}
	
	@GetMapping("/add")
	public int insertStudent(Car car){
		car.setColor("red");
		car.setName("car");
		return service.insertCar(car);
	}
}
