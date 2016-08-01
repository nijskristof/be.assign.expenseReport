package be.assign.expenseReport.controller;

import java.time.Month;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.assign.expenseReport.model.File;
import be.assign.expenseReport.services.FileService;

@Controller
public class FileController {

	@Autowired
	private FileService fileService;

	public ModelAndView newFile(ModelAndView model) {
		File newFile = new File();
		model.addObject("file", newFile);
		model.setViewName("fileForm");
		return model;
	}

	@RequestMapping(value="/getFilesByUser", method = RequestMethod.GET)
	public ModelAndView getAllFiles(HttpServletRequest request){
		long userId = Long.parseLong(request.getParameter("userId"));
		List<File> listFiles = fileService.getFilesByUser(userId);
		ModelAndView model = new ModelAndView("ListFilesForm");
		model.addObject("listFiles", listFiles);
		model.setViewName("ListFiles");
		return model;	
	}
	
	@RequestMapping(value="getFilesByDate", method = RequestMethod.GET)
	public ModelAndView getFilesByDate(HttpServletRequest request){
		Calendar date = Calendar.getInstance();
		//TODO Date is static at the moment, need to be imported out of the view
		date.set(Calendar.YEAR, 2015);
		date.set(Calendar.MONTH, 0);
		List<File> listFiles = fileService.getFilesByDate(date);
		ModelAndView model = new ModelAndView("ListFilesForm");
		model.addObject("listFiles", listFiles);
		model.setViewName("listFiles");
		return model;
	}
	
//	public ModelAndView getFilesByApproval(HttpServletRequest request){
//		List<File> listFiles = fileService.get
//		ModelAndView model = new ModelAndVies("ListFilesForm");
//		model.addObject("listFiles", listFiles);
//		model.seetViewName("listFiles");
//		return model;
//	}
	
}
