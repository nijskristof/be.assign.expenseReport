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
	@Column(name="DATE")
	private Calendar date;
	@Column(name="APPROVAL")
	private boolean approval;
	@OneToMany(mappedBy="details")
	private Set<ExpenseDetail> details;	
	
	public File(){
		
	}
	
	public File(long id){
		super();
		this.id = id;
	}
	
	public File(long id, User user, Calendar month, Calendar year, boolean approval) {
		super();
		this.id = id;
		this.user = user;
		this.date = date;
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

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public boolean isApproval() {
		return approval;
	}

	public void setApproval(boolean approval) {
		this.approval = approval;
	}

	@Override
	public String toString() {
		return "File [id=" + id + ", user=" + user + ", date=" + date + ", approval=" + approval + ", details="
				+ details + "]";
	}
	
}
