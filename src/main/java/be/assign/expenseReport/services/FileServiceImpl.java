package be.assign.expenseReport.services;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.assign.expenseReport.Dao.FileDao;
import be.assign.expenseReport.model.File;

@Service("fileService")
public class FileServiceImpl implements FileService {
	private FileDao fileDao;

	public void setFileDao(FileDao fileDao) {
		this.fileDao = fileDao;
	}

	@Transactional
	@Override
	public File getFileById(long fileId) {
		return this.fileDao.getFileById(fileId);
	}

	@Transactional
	@Override
	public List<File> getFilesByUser(long userId) {
		return this.fileDao.getFilesByUser(userId);
	}

	@Transactional
	@Override
	public List<File> getFilesByDate(Calendar date) {
		return this.fileDao.getFilesByDate(date);
	}

	@Transactional
	@Override
	public List<File> getFilesByappoval(Boolean approval) {
		return this.fileDao.getFilesByappoval(approval);
	}

	@Transactional
	@Override
	public void createFile(File file) {
		this.fileDao.createFile(file);
	}

	@Transactional
	@Override
	public void editFile(File file) {
		this.fileDao.editFile(file);
	}

	@Transactional
	@Override
	public void approveFile(File file) {
		this.fileDao.approveFile(file);
	}

	@Transactional
	@Override
	public void RemoveFile(long fileId) {
		this.fileDao.RemoveFile(fileId);
	}

}
