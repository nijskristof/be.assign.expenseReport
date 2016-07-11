package be.assign.expenseReport.model;

public class UserRole {

	private long id;
	private User user;
	private String role;

	public UserRole() {

	}

	public UserRole(User user, String role) {
		this.user = user;
		this.role = role;
	}

	public UserRole(Long id, User user, String role) {
		this.id = id;
		this.user = user;
		this.role = role;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
