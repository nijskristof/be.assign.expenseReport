package be.assign.expenseReport.Dao;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;

import be.assign.expenseReport.model.User;

public class UserDaoImpl implements UserDao{
	
	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
		
	}
	@Override
	public User getUserById(long userId) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User) session.load(User.class, new Long(userId));
		logger.info("User loaded successfully, user detail: " + user);
		return user;
	}

	@Override
	public List<User> listUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> users = session.createQuery("from User").list();
		for (User user : users){
			logger.info("userslist: " + user);
		}
		return users;
	}

	@Override
	public User getUserByEmail(String email) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User) session.load(User.class, new String(email));
		logger.info("user loaded successfully, user detail: " + user);
		return user;
	}

	
	// TODO check if the double attribute work
	@Override
	public User getUserByName(String firstName, String lastName) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User) session.load(User.class, new String(firstName + lastName));
		logger.info("user loaded successfully, user detail: " + user);
		return user;
	}
	
		

}
