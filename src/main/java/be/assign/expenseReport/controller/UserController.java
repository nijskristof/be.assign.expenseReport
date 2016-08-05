package be.assign.expenseReport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import be.assign.expenseReport.model.User;
import be.assign.expenseReport.services.UserService;

@Controller
public class UserController  {
	
	private UserService userService;
	
	@Autowired(required = true)
	@Qualifier(value="userService")
	public void setPersonService(UserService us){
		this.userService = us;
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String listUsers(Model model){
		model.addAttribute("user", new User());
		model.addAttribute("listUsers", this.userService.listUsers());
		return "user";		
	}
	
	
	

}