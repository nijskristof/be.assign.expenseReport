package be.assign.expenseReport.services;

import java.util.Calendar;
import java.util.List;

import be.assign.expenseReport.model.File;

public interface FileService {
	public File getFileById(long fileId);
	public File getFilesByUser(long userId);
	public List<File> getFilesByDate(Calendar month, Calendar year);
	public File createFile(File file, long userId, Calendar month, Calendar year);
	public void RemoveFile(long fileId);
	
}
