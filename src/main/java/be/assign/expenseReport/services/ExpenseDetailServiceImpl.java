package be.assign.expenseReport.services;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Service;

import be.assign.expenseReport.model.ExpenseDetail;

@Service("ExpenseDetailService")
public class ExpenseDetailServiceImpl implements ExpenseDetailService {
	private EntityManagerFactory emf;

	@PersistenceUnit
	public void setEntityManagerFactory(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public ExpenseDetail getExpenseDetailById(long expenseDetailId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		ExpenseDetail detail = em.find(ExpenseDetail.class, expenseDetailId);
		tx.commit();
		em.close();
		return detail;
	}

	public List<ExpenseDetail> listExpenseDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	public ExpenseDetail getExpenseDetailByApproval(boolean approval) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		ExpenseDetail detail = em.find(ExpenseDetail.class, approval);
		tx.commit();
		em.close();
		return detail;
	}

	public ExpenseDetail createExpenseDetail(long fileId, String description, Calendar date, double subsistenceCosts,
			double restaurantCosts, double transportCosts, double parkingCosts, double otherCosts) {
		EntityManager em = emf.createEntityManager();
		FileServiceImpl fsi = new FileServiceImpl();
		ExpenseDetail detail = new ExpenseDetail();
		detail.setFile(fsi.getFileById(fileId));
		detail.setDescription(description);
		detail.setDate(date);
		detail.setSubsistenceCosts(subsistenceCosts);
		detail.setRestaurantCosts(restaurantCosts);
		detail.setTransportCosts(transportCosts);
		detail.setParkingCosts(parkingCosts);
		detail.setOtherCosts(otherCosts);
		em.persist(detail);
		return detail;
	}

	public ExpenseDetail editExpenseDetail(long expenseDetailId, long fileId, String description, Calendar date,
			double subsistenceCosts, double restaurantCosts, double transportCosts, double parkingCosts,
			double otherCosts) {
		EntityManager em = emf.createEntityManager();
		ExpenseDetail detail = em.find(ExpenseDetail.class, expenseDetailId);
		FileServiceImpl fsi = new FileServiceImpl();
		if (detail != null) {
			detail.setFile(fsi.getFileById(fileId));
			detail.setDescription(description);
			detail.setDate(date);
			detail.setSubsistenceCosts(subsistenceCosts);
			detail.setRestaurantCosts(restaurantCosts);
			detail.setTransportCosts(transportCosts);
			detail.setParkingCosts(parkingCosts);
			detail.setOtherCosts(otherCosts);
		}
		return detail;
	}

	public void removeExpenseDetail(long expenseDetailId) {
		EntityManager em = emf.createEntityManager();
		ExpenseDetail detail = getExpenseDetailById(expenseDetailId);
		if (detail != null) {
			em.remove(detail);
		}

	}

}
