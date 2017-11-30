package study.bobo.service;

import java.util.List;


import study.bobo.domain.Car;

public interface ICarService {
	List<Car> getAll();
	
	Car getOne(Long id);
	
    int insertCar(Car car);
}
