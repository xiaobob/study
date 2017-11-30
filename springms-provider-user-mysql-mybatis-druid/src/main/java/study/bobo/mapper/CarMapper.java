package study.bobo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import study.bobo.domain.Car;

@Repository
public interface CarMapper {
	@Select("select * from car")
	List<Car> getAll();
	
	@Select("select * from car where id=#{id}")
	Car getOne(Long id);
	
	@Insert("INSERT INTO car(name, color) VALUES( #{name}, #{color})")
    int insertCar(Car car);
}
