package be.assign.expenseReport.services;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import be.assign.expenseReport.model.File;

@Service("fileService")
public class FileServiceImpl implements FileService {
	private EntityManagerFactory emf;

	@PersistenceUnit
	public void setEntityManagerFactory(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public File getFileById(long fileId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		File file = em.find(File.class, fileId);
		tx.commit();
		em.close();
		return file;
	}

	public List<File> getFilesByUser(long userId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("select f from FILE f where f.USER_ID = :userId");
		tx.commit();
		em.close();
		return query.setParameter("userId", userId).getResultList();
	}
	
	public List<File> getFilesByDate(Calendar month, Calendar year) {
		return null;
	}

	public File createFile(long userId, Calendar month, Calendar year) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		File file = new File();
		UserServiceImpl user = new UserServiceImpl();
		file.setUser(user.getUser(userId));
		file.setMonth(month);
		file.setYear(year);
		em.persist(file);
		tx.commit();
		em.close();
		return file;
	}
	
	public File editFile(long fileId, Calendar month, Calendar year) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		File file = em.find(File.class, fileId);
		file.setMonth(month);
		file.setYear(year);
		tx.commit();
		em.close();
		return file;
	}

	public File approveFile(long fileId, boolean approval) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		File file = em.find(File.class, fileId);
		file.setApproval(approval);
		tx.commit();
		em.close();
		return file;
	}
	
	public void RemoveFile(long fileId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		File file = getFileById(fileId);
		if (file != null) {
			em.remove(file);
		}
		tx.commit();
		em.close();
	}




}
