package be.assign.expenseReport.dao;

import be.assign.expenseReport.model.UserRole;

public interface UserRoleDao {
	public UserRole getUserRoleById(long id);
	public UserRole getUserRoleByUserId(Long userId);
}
