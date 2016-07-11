package be.assign.expenseReport.model;

import java.util.Calendar;

public class File {
	private long id;
	private User user;
	private Calendar month;
	private Calendar year;
	private boolean approval;
		
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
