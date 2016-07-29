package be.assign.expenseReport.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import org.springframework.stereotype.Service;

import be.assign.expenseReport.model.UserRole;

@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {
	private EntityManagerFactory emf;

	@PersistenceUnit
	public void setEntityManagerFactory(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public UserRole getUserRole(long userRoleId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		UserRole userRole = em.find(UserRole.class, userRoleId);
		tx.commit();
		em.close();
		return userRole;
	}

	@Override
	public UserRole getUserRoleByUserId(Long userId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		UserRole userRole = em.find(UserRole.class, userId);
		tx.commit();
		em.close();
		return userRole;
	}

}
