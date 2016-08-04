package be.assign.expenseReport.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.assign.expenseReport.model.ExpenseDetail;

public class ExpenseDetailDaoImpl implements ExpenseDetailDao {
	private static final Logger logger = LoggerFactory.getLogger(FileDaoImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	public ExpenseDetail getExpenseDetailById(long expenseDetailId) {
		Session session = this.sessionFactory.getCurrentSession();
		ExpenseDetail detail = (ExpenseDetail) session.load(ExpenseDetail.class, expenseDetailId);
		logger.info("detail loaded succesfully, detail: " + detail);
		return detail;
	}

	@Override
	public List<ExpenseDetail> listExpenseDetails() {
		Session session = this.sessionFactory.getCurrentSession();
		List<ExpenseDetail> details= session.createQuery("from EcpenseDetail").list();
		for(ExpenseDetail detail : details){
			logger.info("DetailsList: " + detail);
		}
		return details;
	}

	@Override
	public void createExpenseDetail(ExpenseDetail expenseDetail) {
		Session session= this.sessionFactory.getCurrentSession();
		session.persist(expenseDetail);
		logger.info("ExpenseDetail created succesfully, ExpenseDetail: " + expenseDetail);
	}

	@Override
	public void editExpenseDetail(ExpenseDetail expenseDetail) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(expenseDetail);
		logger.info("ExpenseDetail updated succesfully, ExpenseDetail: " + expenseDetail);
	}

	@Override
	public void removeExpenseDetail(long expenseDetailId) {
		Session session = this.sessionFactory.getCurrentSession();
		ExpenseDetail detail = (ExpenseDetail) session.load(ExpenseDetail.class, new Long(expenseDetailId));
		if(null != detail){
			session.delete(detail);
		}
		logger.info("ExpenseDetail deleted succesfully, ExpenseDetail: " + detail);
	}

}
