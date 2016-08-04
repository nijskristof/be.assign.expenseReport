package be.assign.expenseReport.dao;

import java.util.List;

import be.assign.expenseReport.model.User;

public interface UserDao {
	public User getUserById(long userId);
	public List<User>listUsers();
	public User getUserByEmail(String email);
	public User getUserByName(String firstName, String lastName);
}
