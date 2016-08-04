package be.assign.expenseReport.Dao;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.assign.expenseReport.model.File;

public class FileDaoImpl implements FileDao {
	private static final Logger logger = LoggerFactory.getLogger(FileDaoImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public File getFileById(long fileId) {
		Session session = this.sessionFactory.getCurrentSession();
		File file = (File) session.load(File.class, new Long(fileId));
		logger.info("File loaded successfully, Customer details=" + file);
		return file;
	}

	@Override
	public List<File> getFilesByUser(long userId) {
		Session session = this.sessionFactory.getCurrentSession();
        List<File> files = session.createQuery("from File").list();
        for (File file : files) {
            logger.info("Files:: " + file);
        }
		return files;
	}

	@Override
	public List<File> getFilesByDate(Calendar date) {
		Session session = this.sessionFactory.getCurrentSession();
		List<File> files = session.createQuery("from File where date = " + date).list();
		for (File file : files){
			logger.info("files: "+ file);
		}
		return files;
	}

	@Override
	public List<File> getFilesByappoval(Boolean approval) {
		Session session = this.sessionFactory.getCurrentSession();
		List<File> files = session.createQuery("from File where approval = " + approval).list();
		for(File file : files){
			logger.info("files: " + file);
		}
		return files;
	}

	@Override
	public void createFile(File file) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(file);
		logger.info("File created succesfully, file: " + file);		
	}

	@Override
	public void editFile(File file) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(file);
		logger.info("File updated succesfully, file: " + file);
	}

	@Override
	public void approveFile(File file) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(file);
		logger.info("File updated succesfully, file: " + file);
	}

	@Override
	public void RemoveFile(long fileId) {
		Session session = this.sessionFactory.getCurrentSession();
		File file = (File) session.load(File.class, new Long(fileId));
		if(null != file){
			session.delete(file);
		}
		logger.info("File succesfully deleted, file: " + file);
	}

}
