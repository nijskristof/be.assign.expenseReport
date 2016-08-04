package be.assign.expenseReport.services;

import org.springframework.stereotype.Service;

import be.assign.expenseReport.Dao.UserRoleDao;
import be.assign.expenseReport.model.UserRole;

@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {

	private UserRoleDao userRoleDao;
	public void setUserRoleDao(UserRoleDao userRoleDao){
		this.userRoleDao = userRoleDao;
	}
	public UserRole getUserRoleById(long userRoleId) {
		return this.userRoleDao.getUserRoleById(userRoleId);
	}

	@Override
	public UserRole getUserRoleByUserId(Long userId) {
		return this.userRoleDao.getUserRoleByUserId(userId);
	}

}
