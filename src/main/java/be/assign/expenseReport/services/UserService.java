package be.assign.expenseReport.services;

import java.util.List;

import be.assign.expenseReport.model.User;


public interface UserService {
	public User getUser(long userId);
	public List<User>listUsers();
	public User getUserByEmail(String email);
	public User getUserByName(String firstName, String lastName);
}
