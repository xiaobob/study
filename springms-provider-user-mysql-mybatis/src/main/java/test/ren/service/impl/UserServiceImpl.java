package test.ren.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.ren.domain.User;
import test.ren.mapper.IUserMapper;
import test.ren.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserMapper mapper;
	
	@Override
	public User findUserById(Long id) {
		return mapper.findById(id);
	}

	@Override
	public List<User> findAllUsers() {
		return mapper.getAll();
	}

	@Override
	public int insertUser(User user) {
		return mapper.insertUser(user);
	}

}
