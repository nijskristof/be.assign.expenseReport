package be.assign.expenseReport.services;

import java.util.List;

import org.springframework.stereotype.Service;

import be.assign.expenseReport.dao.UserDao;
import be.assign.expenseReport.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao){
		this.userDao = userDao;
	}
	
	@Override
	public User getUserById(long userId) {
		return this.userDao.getUserById(userId);
	}

	@Override
	public List<User> listUsers() {
		return this.userDao.listUsers();
	}

	@Override
	public User getUserByEmail(String email) {
		return this.userDao.getUserByEmail(email);
	}

	@Override
	public User getUserByName(String firstName, String lastName) {
		return this.userDao.getUserByName(firstName, lastName);
	}
}
