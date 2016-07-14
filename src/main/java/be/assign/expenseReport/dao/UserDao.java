package be.assign.expenseReport.dao;

import java.util.List;

import be.assign.expenseReport.model.User;


public interface UserDao {
	public User getUser(int userId);
	public List<User>list();
}
