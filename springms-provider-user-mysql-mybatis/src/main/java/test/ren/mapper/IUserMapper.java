package test.ren.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import test.ren.domain.User;

public interface IUserMapper {
	@Select("select * from user where id = #{id}")
	User findById(Long id);
	
	@Select("select * from user")
	List<User> getAll();
	
	@Insert("INSERT INTO user(username, name, age, balance) VALUES(#{username}, #{name}, #{age}, #{balance})")
    int insertUser(User user);
}
