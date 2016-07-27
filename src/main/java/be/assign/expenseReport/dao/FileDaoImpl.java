package be.assign.expenseReport.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import be.assign.expenseReport.model.File;
import be.assign.expenseReport.model.User;

public class FileDaoImpl implements FileDao {
	private JdbcTemplate jdbcTemplate;
	UserDaoImpl userDaoImpl = new UserDaoImpl(null);

	public FileDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public File getFilebyId(int fileId) {
		String sql = "SELECT * FROM file WHERE FILE_ID=" + fileId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<File>() {

			@Override
			public File extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					File file = new File();
					file.setId(rs.getLong("file_Id"));
					file.setApproval(rs.getBoolean("approval"));
					// file.setUser(userDaoImpl.getUser(rs.getlong("userId")));
					// file.setMonth(month);
					// file.setYear(year);
					return file;
				}
				return null;
			}
		});
	}

	@Override
	public File getFilesByUser(int user) {
		String sql = "SELECT * FROM file where USER=" + user;
		return jdbcTemplate.query(sql, new ResultSetExtractor<File>() {

			@Override
			public File extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					File file = new File();
					file.setId(rs.getLong("file_Id"));
					file.setApproval(rs.getBoolean("approval"));
					// the other properties need to be implemented here
					return file;
				}
				return null;
			}
		});
	}

	@Override
	public File getFilesByDate(Calendar month, Calendar year) {
		String sql = "SELECT * FROM file where MONTH=" + month + "and YEAR=" + year;
		return jdbcTemplate.query(sql, new ResultSetExtractor<File>() {

			@Override
			public File extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					File file = new File();
					file.setId(rs.getLong("file_id"));
					file.setApproval(rs.getBoolean("approval"));
					// the other properties need to be implemented here
					return file;
				}
				return null;
			}
		});
	}

	@Override
	public void createFile(File file) {
		String sql = "INSERT INTO file(user, month, year, approval"+"VALUES(?,?,?,?)";
		jdbcTemplate.update(sql, file.getUser(), file.getMonth(), file.getYear(), file.isApproval());		
	}

}
