package test.ren.service;

import java.util.List;

import test.ren.domain.User;

public interface IUserService {
	User findUserById(Long id);

	List<User> findAllUsers();

	int insertUser(User user);
}
