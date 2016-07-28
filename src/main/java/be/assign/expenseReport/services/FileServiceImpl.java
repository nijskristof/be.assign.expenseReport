package be.assign.expenseReport.services;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
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

	public File getFilesByUser(long userId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		File file = em.find(File.class, userId);
		tx.commit();
		em.close();
		return file;
	}

	@Override
	public List<File> getFilesByDate(Calendar month, Calendar year) {
		// TODO Auto-generated method stub
		return null;
	}

	public File createFile(File file, long userId, Calendar month, Calendar year) {
		EntityManager em = emf.createEntityManager();
		File newFile = new File(file.getId());
		UserServiceImpl user = new UserServiceImpl();
		newFile.setUser(user.getUser(userId));
		newFile.setMonth(month);
		newFile.setYear(year);
		em.persist(newFile);
		return newFile;
	}

	public void RemoveFile(long fileId) {
		EntityManager em = emf.createEntityManager();
		File file = getFileById(fileId);
		if (file != null) {
			em.remove(file);
		}
	}

}
