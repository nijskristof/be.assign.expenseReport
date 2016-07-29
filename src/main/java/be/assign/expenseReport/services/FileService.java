	package be.assign.expenseReport.services;

import java.util.Calendar;
import java.util.List;

import be.assign.expenseReport.model.File;

public interface FileService {
	public File getFileById(long fileId);
	public List<File> getFilesByUser(long userId);
	public List<File> getFilesByDate(Calendar month, Calendar year);
	public File createFile(long userId, Calendar month, Calendar year);
	public File editFile(long fileId, Calendar month, Calendar year);
	public File approveFile(long fileId, boolean approval);
	public void RemoveFile(long fileId);
	
}
