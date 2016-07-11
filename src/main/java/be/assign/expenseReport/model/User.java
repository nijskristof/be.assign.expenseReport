package be.assign.expenseReport.model;

import java.util.List;

public class User {

	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String nationalIdNumber;
	private String account;
	private UserRole userRole;
	private List<File> file;

	public User() {
	}

	public User(String firstName, String LastName){
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
