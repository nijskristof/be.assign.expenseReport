package be.assign.expenseReport.services;

import java.util.Calendar;
import java.util.List;

import be.assign.expenseReport.model.ExpenseDetail;

public interface ExpenseDetailService {
	public ExpenseDetail getExpenseDetailById(long expenseDetailId);
	public List<ExpenseDetail> listExpenseDetails();
	public ExpenseDetail getExpenseDetailByApproval(boolean approval);
	public ExpenseDetail createExpenseDetail(long fileId, String description, Calendar date, double subsistenceCosts,
			double restaurantCosts, double transportCosts, double parkingCosts, double otherCosts);
	public ExpenseDetail editExpenseDetail(long expenseDetailId, long fileId, String description, Calendar date, double subsistenceCosts,
			double restaurantCosts, double transportCosts, double parkingCosts, double otherCosts);
	public void removeExpenseDetail(long expenseDetailId);
}
