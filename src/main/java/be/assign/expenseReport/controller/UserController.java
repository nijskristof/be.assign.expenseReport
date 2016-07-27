package be.assign.expenseReport.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.assign.expenseReport.dao.UserDao;
import be.assign.expenseReport.model.User;

public class UserController  {
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value="/")
	public ModelAndView listUser(ModelAndView model) throws IOException{
	    List<User> listUser = userDao.list();
	    model.addObject("listUser", listUser);
	    model.setViewName("user");
	 
	    return model;
	}
	
	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public ModelAndView getUser(HttpServletRequest request) {
	    int userId = Integer.parseInt(request.getParameter("id"));
	    User user = userDao.getUser(userId);
	    ModelAndView model = new ModelAndView("UserForm");
	    model.addObject("user", user);
	    System.out.println(user);
	    return model;
	}	
}