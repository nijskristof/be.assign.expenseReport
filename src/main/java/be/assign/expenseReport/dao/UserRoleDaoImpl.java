package be.assign.expenseReport.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import be.assign.expenseReport.model.UserRole;

public class UserRoleDaoImpl implements UserRoleDao {
	
	private JdbcTemplate jdbcTemplate;
	UserRoleDaoImpl userRoleDaoImpl = new UserRoleDaoImpl(null);

	public UserRoleDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public UserRole getUserRole(int userRoleId) {
		String sql="SELECT * from userrole WHERE userrole_id=" + userRoleId;		
		return jdbcTemplate.query(sql, new ResultSetExtractor<UserRole>(){
			@Override
			public UserRole extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()){
					UserRole userRole = new UserRole();
					userRole.setId(rs.getLong("userrole_id"));
					userRole.setUserId(rs.getLong("user_id"));
					userRole.setRole(rs.getString("userrole"));
				}
				return null;
			}
		
			
		});
	}

}
