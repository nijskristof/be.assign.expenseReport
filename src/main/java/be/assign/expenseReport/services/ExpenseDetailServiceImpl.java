package be.assign.expenseReport.services;

import java.util.List;

import org.springframework.stereotype.Service;

import be.assign.expenseReport.dao.ExpenseDetailDao;
import be.assign.expenseReport.model.ExpenseDetail;

@Service("ExpenseDetailService")
public class ExpenseDetailServiceImpl implements ExpenseDetailService {
	private ExpenseDetailDao expenseDetailDao;
	
	public void setExpenseDetail(ExpenseDetailDao expenseDetailDao){
		this.expenseDetailDao = expenseDetailDao;
	}
	
	@Override
	public ExpenseDetail getExpenseDetailById(long expenseDetailId) {
		return this.expenseDetailDao.getExpenseDetailById(expenseDetailId);
	}

	@Override
	public List<ExpenseDetail> listExpenseDetails() {
		return this.expenseDetailDao.listExpenseDetails();
	}

	@Override
	public void createExpenseDetail(ExpenseDetail expenseDetail) {
		this.expenseDetailDao.createExpenseDetail(expenseDetail);
	}

	@Override
	public void editExpenseDetail(ExpenseDetail expenseDetail) {
		this.expenseDetailDao.editExpenseDetail(expenseDetail);
	}

	@Override
	public void removeExpenseDetail(long expenseDetailId) {
		this.expenseDetailDao.removeExpenseDetail(expenseDetailId);		
	}
	

}
