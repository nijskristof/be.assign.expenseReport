package be.assign.expenseReport.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import be.assign.expenseReport.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {
	private EntityManagerFactory emf;

	@PersistenceUnit
	public void setEntityManagerFactory(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public User getUser(long userId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		User user = em.find(User.class, userId);
		tx.commit();
		em.close();
		return user;
	}

	//TODO search how to import multiple objects
	public List<User> listUsers() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT u FROM User u");
		return (List<User>) query.getResultList();
	}

	public User getUserByEmail(String email) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		User user = em.find(User.class, email);
		tx.commit();
		em.close();
		return user;
	}

	//TODO search how to import object with multiple attributes
	public User getUserByName(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}
}
