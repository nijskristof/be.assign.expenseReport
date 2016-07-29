package be.assign.expenseReport.services;

import be.assign.expenseReport.model.UserRole;

public interface UserRoleService {
	public UserRole getUserRole(long id);
	public UserRole getUserRoleByUserId(Long userId);
}
