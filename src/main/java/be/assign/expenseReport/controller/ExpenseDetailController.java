package be.assign.expenseReport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import be.assign.expenseReport.model.ExpenseDetail;
import be.assign.expenseReport.services.ExpenseDetailService;

@Controller
public class ExpenseDetailController {
	private ExpenseDetailService expenseDetailService;

	@Autowired(required = true)
	@Qualifier(value = "expenseDetailService")
	public void setExpenseDetailService(ExpenseDetailService es){
		this.expenseDetailService = es;
	}
	
	@RequestMapping(value = "/expenseDetails", method = RequestMethod.GET)
	public String listExpenseDetails(Model model){
		model.addAttribute("expenseDetail", new ExpenseDetail());
		model.addAttribute("expenseDetails" , this.expenseDetailService.listExpenseDetails());
		return "expenseDetail";		
	}
	
	@RequestMapping(value = "/expenseDetails/add", method = RequestMethod.POST)
	public String addExpenseDetail(@ModelAttribute("expenseDetail") ExpenseDetail e){
		if(e.getId() == 0){
			this.expenseDetailService.createExpenseDetail(e);
		}else{
			this.expenseDetailService.editExpenseDetail(e);
		}
		return "redirect:/expenseDetails";		
	}

	@RequestMapping("/expenseDetails/remove/{id}")
	public String removeExpenseDetail(@PathVariable("id")long id){
		this.expenseDetailService.removeExpenseDetail(id);
		return "redirect:/expenseDetails";
	}
	
	public String editExpenseDetail(@PathVariable("id")long id, Model model){
		model.addAttribute("expenseDetail", this.expenseDetailService.getExpenseDetailById(id));
		model.addAttribute("expenseDetails", this.expenseDetailService.listExpenseDetails());
		return "expenseDetail";
	}
	
}
