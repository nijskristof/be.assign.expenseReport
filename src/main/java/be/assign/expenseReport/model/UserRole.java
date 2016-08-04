package be.assign.expenseReport.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "userrole")
public class UserRole {

	@Id
	@GeneratedValue
	@Column(name = "USERROLE_ID")
	private long id;
	@OneToMany(mappedBy = "user")
	private Set<User> users;
	@Column(name = "ROLE")
	private String role;

	public UserRole() {

	}

	public UserRole(Set<User> users, String role) {
		this.users = users;
		this.role = role;
	}

	public UserRole(Long id, Set<User> users, String role) {
		this.id = id;
		this.users = users;
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserRole [id=" + id + ", users=" + users + ", role=" + role + "]";
	}
	
}
