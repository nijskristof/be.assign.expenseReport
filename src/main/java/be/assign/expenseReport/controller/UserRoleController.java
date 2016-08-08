package be.assign.expenseReport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import be.assign.expenseReport.model.UserRole;
import be.assign.expenseReport.services.UserRoleService;

@Controller
public class UserRoleController {
	private UserRoleService userRoleService;
	
	@Autowired
	@Qualifier(value = "UserRoleService")
	public void setUserRoleService(UserRoleService us) {
		this.userRoleService = us;
	}
	
	@RequestMapping(value = "/userRoles/id", method = RequestMethod.GET)
	public String getUserRoleById(Model model, long Id){
		model.addAttribute("userRole", new UserRole());
		model.addAttribute("userRoles", this.userRoleService.getUserRoleById(Id));
		return "UserRole";
	}
	
	@RequestMapping(value = "/userRoles/userId", method = RequestMethod.GET)
	public String getUserRoleByUserId(Model model, long userId){
		model.addAttribute("userRole", new UserRole());
		model.addAttribute("userRoles", this.userRoleService.getUserRoleByUserId(userId));
		return "UserRole";
	}
	
}
