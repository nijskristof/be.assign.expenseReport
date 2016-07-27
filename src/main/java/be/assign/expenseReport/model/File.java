package be.assign.expenseReport.model;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.*;

public class File {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private long id;
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;
	@Column(name="MONTH")
	private Calendar month;
	@Column(name="YEAR")
	private Calendar year;
	@Column(name="APPROVAL")
	private boolean approval;
	@OneToMany(mappedBy="details")
	private Set<ExpenseDetail> details;	
	
	public File(){
		
	}

	public File(long id, User user, Calendar month, Calendar year, boolean approval) {
		super();
		this.id = id;
		this.user = user;
		this.month = month;
		this.year = year;
		this.approval = approval;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Calendar getMonth() {
		return month;
	}

	public void setMonth(Calendar month) {
		this.month = month;
	}

	public Calendar getYear() {
		return year;
	}

	public void setYear(Calendar year) {
		this.year = year;
	}

	public boolean isApproval() {
		return approval;
	}

	public void setApproval(boolean approval) {
		this.approval = approval;
	}
	
}
