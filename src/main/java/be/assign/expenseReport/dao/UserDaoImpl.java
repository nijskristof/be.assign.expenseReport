package be.assign.expenseReport.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import be.assign.expenseReport.model.User;

public class UserDaoImpl implements UserDao {
	private JdbcTemplate jdbcTemplate;

	public UserDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public User getUser(int userId) {
		String sql = "SELECT * FROM user WHERE USER_ID=" + userId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<User>(){

			@Override
			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()){
					User user = new User();
					user.setId(rs.getLong("user_id"));
					user.setFirstName(rs.getString("firstName"));
					user.setLastName(rs.getString("lastName"));
					user.setEmail(rs.getString("email"));
					user.setAccount(rs.getString("account"));
					user.setNationalIdNumber(rs.getString("nationalIdNumber"));
					return user;
			}
			return null;
			}
		});
	}

	@Override
	public List<User> list() {
		String sql = "SELECT * FROM user";
		List<User> listUser = jdbcTemplate.query(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User aUser = new User();

				aUser.setId(rs.getLong("user_id"));
				aUser.setFirstName(rs.getString("firstName"));
				aUser.setLastName(rs.getString("lastName"));
				aUser.setEmail(rs.getString("email"));
				aUser.setAccount(rs.getString("account"));
				aUser.setNationalIdNumber(rs.getString("nationalIdNumber"));
				aUser.setUserRole(userRole);
				return aUser;
			}
		});
		return listUser;
	}





	// private DataSource ds;
	// private static final String GET_QUERY = "select firstName, lastName, file
	// from User order by lastName";
	//
	// public UserDaoImpl(DataSource ds){
	// this.ds = ds;
	// }
	//
	// public List<User> getUserItems() throws SQLException {
	// try (Connection con = ds.getConnection();
	// Statement stmt = con.createStatement()) {
	// List<User> messages = new ArrayList<User>();
	// ResultSet rs = stmt.executeQuery(GET_QUERY);
	// while (rs.next()) {
	// User user = new User(rs.getString(1),
	// rs.getString(2));
	// messages.add(user);
	// }
	// rs.close();
	// return messages;
	// }
	// }

}
