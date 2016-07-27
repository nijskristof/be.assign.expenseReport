package be.assign.expenseReport.dao;

import java.util.Calendar;

import be.assign.expenseReport.model.File;

public interface FileDao {
	public File getFilebyId(int fileId);
	public File getFilesByUser(int user);
	public File getFilesByDate(Calendar month, Calendar year);
	public void createFile(File file);
	
}
