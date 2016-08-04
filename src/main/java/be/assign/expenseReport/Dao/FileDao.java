package be.assign.expenseReport.Dao;

import java.util.Calendar;
import java.util.List;

import be.assign.expenseReport.model.File;

public interface FileDao {
	public File getFileById(long fileId);
	public List<File> getFilesByUser(long userId);
	public List<File> getFilesByDate(Calendar date);
	public List<File> getFilesByappoval(Boolean approval);
	public void createFile(File file);
	public void editFile(File file);
	public void approveFile(File file);
	public void RemoveFile(long fileId);
}
