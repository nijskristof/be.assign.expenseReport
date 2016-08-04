package be.assign.expenseReport.services;

import be.assign.expenseReport.model.UserRole;

public interface UserRoleService {
	public UserRole getUserRoleById(long id);
	public UserRole getUserRoleByUserId(Long userId);
}
