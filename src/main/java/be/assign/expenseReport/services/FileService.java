	package be.assign.expenseReport.services;

import java.util.Calendar;
import java.util.List;

import be.assign.expenseReport.model.File;

public interface FileService {
	public File getFileById(long fileId);
	public List<File> getFilesByUser(long userId);
	public List<File> getFilesByDate(Calendar date);
	public List<File> getFilesByappoval(Boolean approval);
	public File createFile(long userId, Calendar date);
	public File editFile(long fileId, Calendar date);
	public File approveFile(long fileId, boolean approval);
	public void RemoveFile(long fileId);
	
}
