package be.assign.expenseReport.Dao;

import java.util.List;

import be.assign.expenseReport.model.ExpenseDetail;

public interface ExpenseDetailDao {
	public ExpenseDetail getExpenseDetailById(long expenseDetailId);

	public List<ExpenseDetail> listExpenseDetails();

	public void createExpenseDetail(ExpenseDetail expenseDetail);

	public void editExpenseDetail(ExpenseDetail expenseDetail);

	public void removeExpenseDetail(long expenseDetailId);
}
