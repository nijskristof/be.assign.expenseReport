package be.assign.expenseReport.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import be.assign.expenseReport.model.File;
import be.assign.expenseReport.services.FileService;

@Controller
public class FileController {
	private FileService fileService;

	@Autowired
	@Qualifier(value = "FileService")
	public void setFilesService(FileService fs) {
		this.fileService = fs;
	}

	@RequestMapping(value = "/files/date", method = RequestMethod.GET)
	public String listFilesByDate(Model model, Calendar date) {
		model.addAttribute("file", new File());
		model.addAttribute("files", fileService.getFilesByDate(date));
		return "file";
	}

	@RequestMapping(value = "/files/user", method = RequestMethod.GET)
	public String listFilesByUser(Model model, long userId) {
		model.addAttribute("file", new File());
		model.addAttribute("files", fileService.getFilesByUser(userId));
		return "file";
	}

	@RequestMapping(value = "/files/approval", method = RequestMethod.GET)
	public String listFilesByApproval(Model model, boolean approval) {
		model.addAttribute("file", new File());
		model.addAttribute("files", fileService.getFilesByappoval(approval));
		return "file";
	}

	@RequestMapping(value = "/files/add", method = RequestMethod.POST)
	public String createFile(@ModelAttribute("file") File f) {
		if (f.getId() == 0) {
			this.fileService.createFile(f);
		} else {
			this.fileService.editFile(f);
		}
		return "redirect:/files";
	}

	@RequestMapping("/files/remove/{fileId}")
	public String removeFile(@PathVariable("fileId") long fileId) {
		this.fileService.RemoveFile(fileId);
		return "redirect:/files";
	}

	// TODO create a getfiles in service and dao
	public String editFile(@PathVariable("fileId") long fileId, Model model) {
		model.addAttribute("file", this.fileService.getFileById(fileId));
		// model.addAttribute("files", this.fileService.get)
		return "file";
	}

	
}
