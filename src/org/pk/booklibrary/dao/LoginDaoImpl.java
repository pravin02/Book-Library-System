package org.pk.booklibrary.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.pk.booklibrary.model.User;
import org.pk.booklibrary.model.UserStatus;
import org.pk.booklibrary.model.UserType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

/**
 * LoginDaoImpl providing implementation for LoginDoa interface. LoginDaoImpl
 * code used to login
 * 
 * @author SHREE
 */
@Component
final class LoginDaoImpl implements LoginDao {

	/**
	 * dataSource object is useful to get driver details of different types of
	 * database vendors like MYSql, Oracle, SQL Server, Cybase
	 */
	// private DataSource dataSource;
	/**
	 * jdbcTemplateObject is used to actually make connection with database and
	 * Spring JDBC API.
	 */
	private JdbcTemplate jdbcTemplateObject;

	/**
	 * dataSource object will be injected by spring configuration at run time.
	 * 
	 * @param dataSource
	 */
	public void setDataSource(DataSource dataSource) {
		// this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.pk.booklibrary.dao.LoginDao#isMobileOrEmailAllreadyExists(java.lang
	 * .String, java.lang.String)
	 */
	@Override
	public String isMobileOrEmailAllreadyExists(String mobileNumber, String emailId) {
		String SQL = "{CALL isUserExists(?, ?)}";
		List<String> list = jdbcTemplateObject.query(SQL, new RowMapper<String>() {
			@Override
			public String mapRow(java.sql.ResultSet rs, int rowMap) throws SQLException {
				return rs.getString(1);
			}
		}, new Object[] { mobileNumber, emailId });
		return (list != null && !list.isEmpty()) ? list.get(0) : null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.pk.booklibrary.dao.LoginDao#loginUser(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public User loginUser(String emailId, String password) {
		String SQL = "{CALL loginUser(?, ?)}";
		List<User> userList = jdbcTemplateObject.query(SQL, new RowMapper<User>() {
			@Override
			public User mapRow(java.sql.ResultSet rs, int rowMap) throws SQLException {
				User user = new User();
				user.setUserId(rs.getInt("userId"));
				user.setEmailId(rs.getString("emailId"));
				user.setPassword(rs.getString("password"));
				user.setFullName(rs.getString("fullName"));
				user.setGender(rs.getString("gender"));
				user.setDob(rs.getString("dob"));
				user.setMobileNo(rs.getString("mobileNumber"));
				user.setAddress(rs.getString("address"));
				user.setImage(rs.getString("image"));
				user.setDesignation(rs.getString("designation"));
				user.setUserType(UserType.getUserStatus(rs.getString("userType")));
				user.setUserStatus(UserStatus.getUserStatus(rs.getString("status")));
				return user;
			}
		}, new Object[] { emailId, password });
		return (userList != null && userList.size() == 1) ? userList.get(0) : null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.pk.booklibrary.dao.LoginDao#loginAdmin(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public User loginAdmin(String emailId, String password) {
		String SQL = "{CALL loginAdmin(?, ?)}";
		List<User> userList = jdbcTemplateObject.query(SQL, new RowMapper<User>() {
			@Override
			public User mapRow(java.sql.ResultSet rs, int rowMap) throws SQLException {
				User user = new User();
				user.setUserId(rs.getInt("userId"));
				user.setEmailId(rs.getString("emailId"));
				user.setPassword(rs.getString("password"));
				user.setFullName(rs.getString("fullName"));
				user.setGender(rs.getString("gender"));
				user.setDob(rs.getString("dob"));
				user.setMobileNo(rs.getString("mobileNumber"));
				user.setAddress(rs.getString("address"));
				user.setImage(rs.getString("image"));
				user.setDesignation(rs.getString("designation"));
				user.setUserType(UserType.getUserStatus(rs.getString("userType")));
				user.setUserStatus(UserStatus.getUserStatus(rs.getString("status")));
				return user;
			}
		}, new Object[] { emailId, password });
		return (userList != null && userList.size() == 1) ? userList.get(0) : null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.pk.booklibrary.dao.LoginDao#updatePassword(int,
	 * java.lang.String, java.lang.String)
	 */
	public String updatePassword(int userId, String oldPassword, String newPassword) {
		String SQL = "{CALL updateUserPassword(?, ?, ?)}";
		List<String> userList = jdbcTemplateObject.query(SQL, new RowMapper<String>() {
			@Override
			public String mapRow(java.sql.ResultSet rs, int rowMap) throws SQLException {
				return rs.getString("message");
			}
		}, new Object[] { userId, oldPassword, newPassword });
		return (userList != null && userList.size() == 1) ? userList.get(0) : null;
	}

}