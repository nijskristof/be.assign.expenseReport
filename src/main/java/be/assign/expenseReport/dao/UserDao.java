package be.assign.expenseReport.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.sql.DataSource;

import be.assign.expenseReport.model.User;

public class UserDao {
	private DataSource ds;
	private static final String GET_QUERY = "select firstName, lastName, file from User order by lastName";
	
	public UserDao(DataSource ds){
		this.ds = ds;
	}
	
	public List<User> getUserItems() throws SQLException {
		try (Connection con = ds.getConnection();
			Statement stmt = con.createStatement()) {
		List<User> messages = new ArrayList<User>();
		ResultSet rs = stmt.executeQuery(GET_QUERY);
		while (rs.next()) {
			User user = new User(rs.getString(1),
					rs.getString(2));
			messages.add(user);
		}
		rs.close();
		return messages;
	}
}
	

}
