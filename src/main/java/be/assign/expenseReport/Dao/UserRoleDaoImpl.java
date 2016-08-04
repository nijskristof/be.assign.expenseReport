package be.assign.expenseReport.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.assign.expenseReport.model.UserRole;

public class UserRoleDaoImpl implements UserRoleDao {
	private static final Logger logger = LoggerFactory.getLogger(UserRoleDaoImpl.class);
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public UserRole getUserRoleById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		UserRole userRole = (UserRole) session.load(UserRole.class, new Long(id));
		logger.info("UserRole loaded successfully, UserRole: " + userRole);
		return userRole;
	}

	//TODO check if result works
	@Override
	public UserRole getUserRoleByUserId(Long userId) {
		Session session= this.sessionFactory.getCurrentSession();
		UserRole userRole = (UserRole) session.load(UserRole.class, new Long (userId));
		logger.info("UserRole loaded successfully, UserRole: " + userRole);
		return userRole;
	}

}
