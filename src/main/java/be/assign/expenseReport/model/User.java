package be.assign.expenseReport.model;

import java.util.List;

import javax.persistence.*;

public class User {
	@Id
	@GeneratedValue
	@Column(name="USER_ID")
	private long id;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="EMAIL")
	private String email;
	@Column(name="NATIONALIDNUMBER")
	private String nationalIdNumber;
	@Column(name="BANK_ACCOUNT")
	private String account;
	@ManyToOne
	@JoinColumn(name="USERROLE_ID")
	private UserRole userRole;
	@OneToMany(mappedBy="FILE_ID")
	private List<File> file;

	public User() {
	}

	public User(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
	public User(String firstName, String lastName, List<File> file){
		this.firstName = firstName;
		this.lastName = lastName;
		this.file = file;
	}
	
	public User(long id, String firstName, String lastName, String email, String nationalIdNumber, String account,
			UserRole userRole) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.nationalIdNumber = nationalIdNumber;
		this.account = account;
		this.userRole = userRole;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNationalIdNumber() {
		return nationalIdNumber;
	}

	public void setNationalIdNumber(String nationalIdNumber) {
		this.nationalIdNumber = nationalIdNumber;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public List<File> getFile() {
		return file;
	}

	public void setFile(List<File> file) {
		this.file = file;
	}

}
