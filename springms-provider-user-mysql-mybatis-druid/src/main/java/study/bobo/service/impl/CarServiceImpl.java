package study.bobo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.bobo.domain.Car;
import study.bobo.mapper.CarMapper;
import study.bobo.service.ICarService;

@Service
@Transactional
public class CarServiceImpl implements ICarService{

	@Autowired
	private CarMapper mapper;
	
	@Override
	public List<Car> getAll() {
		return mapper.getAll();
	}

	@Override
	public Car getOne(Long id) {
		return mapper.getOne(id);
	}

	@Override
	public int insertCar(Car car) {
		return mapper.insertCar(car);
	}

}
