package org.pk.booklibrary.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.pk.booklibrary.model.Book;
import org.pk.booklibrary.model.BookCategory;
import org.pk.booklibrary.model.BookIssueStatus;
import org.pk.booklibrary.model.Dashboard;
import org.pk.booklibrary.model.Education;
import org.pk.booklibrary.model.Fine;
import org.pk.booklibrary.model.IssuedBook;
import org.pk.booklibrary.model.User;
import org.pk.booklibrary.model.UserStatus;
import org.pk.booklibrary.model.UserType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

/**
 * UserDaoImpl providing implementation for UserDao interface which has object
 * functionalities.
 * 
 * @author SHREE
 */

@Component
final class UserDaoImpl implements UserDao {

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

	/**
	 * @return the jdbcTemplateObject
	 */
	public JdbcTemplate getJdbcTemplateObject() {
		return jdbcTemplateObject;
	}

	/**
	 * @param jdbcTemplateObject
	 *            the jdbcTemplateObject to set
	 */
	public void setJdbcTemplateObject(JdbcTemplate jdbcTemplateObject) {
		this.jdbcTemplateObject = jdbcTemplateObject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.pk.booklibrary.dao.UserDao#getDashboardData()
	 */
	@Override
	public Dashboard getDashboardData() {
		String SQL = "{CALL getDashboardData()}";
		List<Dashboard> list = jdbcTemplateObject.query(SQL, new RowMapper<Dashboard>() {
			@Override
			public Dashboard mapRow(java.sql.ResultSet rs, int rowMap) throws SQLException {
				Dashboard object = new Dashboard(rs.getInt("totalStudents"), rs.getInt("totalStaffs"),
						rs.getInt("totalBookCategories"), rs.getInt("totalBooks"));
				return object;
			}
		});
		return (list != null && list.size() == 1) ? list.get(0) : null;
	}

	public List<User> getUsersByUserType(String userType) {
		String SQL = "{CALL getUsersByUserType(?)}";
		List<User> list = jdbcTemplateObject.query(SQL, new RowMapper<User>() {
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
				user.setCountry(rs.getString("country"));
				user.setState(rs.getString("state"));
				user.setCity(rs.getString("city"));
				user.setAddress(rs.getString("address"));
				user.setDesignation(rs.getString("designation"));
				user.setImage(rs.getString("image"));
				user.setUserType(UserType.getUserStatus(rs.getString("userType")));
				user.setUserStatus(UserStatus.getUserStatus(rs.getString("status")));
				return user;
			}
		}, new Object[] { userType });
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.pk.booklibrary.dao.UserDao#getUserDetails(int)
	 */
	@Override
	public User getUserDetails(int userId) {
		String SQL = "{CALL getUserDetails(?)}";
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
				user.setCountry(rs.getString("country"));
				user.setState(rs.getString("state"));
				user.setCity(rs.getString("city"));
				user.setAddress(rs.getString("address"));
				user.setDesignation(rs.getString("designation"));
				user.setImage(rs.getString("image"));
				user.setUserType(UserType.getUserStatus(rs.getString("userType")));
				user.setUserStatus(UserStatus.getUserStatus(rs.getString("status")));
				return user;
			}
		}, new Object[] { userId });
		return (userList != null && userList.size() == 1) ? userList.get(0) : null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.pk.booklibrary.dao.UserDao#registerUser(org.pk.booklibrary.model.
	 * User)
	 */
	@Override
	public boolean registerUser(User user) {
		String SQL = "{CALL registerUser(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? , ? , ?)}";
		return jdbcTemplateObject.update(SQL,
				new Object[] { user.getFullName(), user.getEmailId(), user.getPassword(), user.getGender(),
						user.getDob(), user.getMobileNo(), user.getCountry(), user.getState(), user.getCity(),
						user.getAddress(), user.getImage(), user.getDesignation(), user.getUserType().name()

				}) == 1 ? true : false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.pk.booklibrary.dao.UserDao#updateUserStatus(int,
	 * java.lang.String)
	 */
	@Override
	public boolean updateUserStatus(int userId, String userStatus) {

		String SQL = "{CALL updateUserStatus(?, ?)}";
		return jdbcTemplateObject.update(SQL, new Object[] { userId, userStatus }) == 1 ? true : false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.pk.booklibrary.dao.UserDao#updateUser(int,
	 * org.pk.booklibrary.model.User)
	 */
	@Override
	public boolean updateUser(int userId, User user) {
		String SQL = "{CALL updateUser(?, ?, ?)}";
		return jdbcTemplateObject.update(SQL, new Object[] { userId, user.getMobileNo(), user.getAddress() }) == 1
				? true : false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.pk.booklibrary.dao.UserDao#updateUserProfilePic(int,
	 * java.lang.String)
	 */
	@Override
	public boolean updateUserProfilePic(int userId, String imageName) {
		String SQL = "{CALL updateUserProfilePic(?, ?)}";
		return jdbcTemplateObject.update(SQL, new Object[] { userId, imageName }) == 1 ? true : false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.pk.booklibrary.dao.UserDao#addBookCategory(org.pk.booklibrary.model.
	 * BookCategory)
	 */
	@Override
	public boolean addBookCategory(BookCategory bookCategory) {
		String SQL = "{CALL addBookCategory(?, ?)}";
		return jdbcTemplateObject.update(SQL,
				new Object[] { bookCategory.getCategory(), bookCategory.getDescription() }) == 1 ? true : false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.pk.booklibrary.dao.UserDao#getBookCategories()
	 */
	@Override
	public List<BookCategory> getBookCategories() {
		String SQL = "{CALL getBookCategories()}";
		List<BookCategory> list = jdbcTemplateObject.query(SQL, new RowMapper<BookCategory>() {
			@Override
			public BookCategory mapRow(java.sql.ResultSet rs, int numRow) throws SQLException {
				return new BookCategory(rs.getInt("categoryId"), rs.getString("category"), rs.getString("description"),
						rs.getString("image"));
			}
		});
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.pk.booklibrary.dao.UserDao#getCategoryById(int)
	 */
	@Override
	public BookCategory getBookCategoryById(int id) {
		String SQL = "{CALL getBookCategoryById(?)}";
		List<BookCategory> list = jdbcTemplateObject.query(SQL, new RowMapper<BookCategory>() {
			@Override
			public BookCategory mapRow(java.sql.ResultSet rs, int numRow) throws SQLException {
				return new BookCategory(rs.getInt("categoryId"), rs.getString("category"), 
						rs.getString("description"),
						rs.getString("image"));
			}
		}, id);
		return (list != null && list.size() == 1) ? list.get(0) : null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.pk.booklibrary.dao.UserDao#addBook(org.pk.booklibrary.model.Book)
	 */
	@Override
	public boolean addBook(Book book) {
		String SQL = "{CALL addBook(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
		return jdbcTemplateObject.update(SQL,
				new Object[] { book.getBookCategory().getCategoryId(), book.getTitle(), book.getAuthor(),
						book.getPublication(), book.getIsbn(), book.getYear(), book.getImage(), book.getDescription(),
						book.getCopies(), book.getRackNo() }) == 1 ? true : false;
	}

	/**
	 * @param categoryId
	 * @return
	 */
	@Override
	public List<Book> getBooksByCategoryId(int categoryId) {
		String SQL = "{CALL getBooksByCategoryId(?)}";
		List<Book> list = jdbcTemplateObject.query(SQL, new RowMapper<Book>() {
			@Override
			public Book mapRow(java.sql.ResultSet rs, int numRow) throws SQLException {
				return new Book(rs.getInt("bookId"), getBookCategoryById(rs.getInt("categoryId")),
						rs.getString("title"), rs.getString("author"), rs.getString("ISBN"),
						rs.getString("publication"), rs.getInt("year"), rs.getString("image"),
						rs.getString("description"), rs.getInt("copies"), rs.getInt("availableBookCopies"), rs.getString("rackNo"));
			}
		}, categoryId);
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.pk.booklibrary.dao.UserDao#searchBooks(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<Book> searchBooks(String title, String autor, String publication, String category) {
		String SQL = "{CALL searchBook(?, ?, ?, ?)}";
		List<Book> list = jdbcTemplateObject.query(SQL, new RowMapper<Book>() {
			@Override
			public Book mapRow(java.sql.ResultSet rs, int numRow) throws SQLException {
				return new Book(rs.getInt("bookId"), getBookCategoryById(rs.getInt("categoryId")),
						rs.getString("title"), rs.getString("author"), rs.getString("ISBN"),
						rs.getString("publication"), rs.getInt("year"), rs.getString("image"),
						rs.getString("description"), rs.getInt("copies"), rs.getInt("availableBookCopies"), rs.getString("rackNo"));
			}
		}, title, autor, publication, category);
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.pk.booklibrary.dao.UserDao#getBookById(int, int)
	 */
	@Override
	public Book getBookById(int categoryId, int id) {

		String SQL = "{CALL getBookById(?, ?)}";
		List<Book> list = jdbcTemplateObject.query(SQL, new RowMapper<Book>() {
			@Override
			public Book mapRow(java.sql.ResultSet rs, int numRow) throws SQLException {
				return new Book(rs.getInt("bookId"), getBookCategoryById(rs.getInt("categoryId")),
						rs.getString("title"), rs.getString("author"), rs.getString("ISBN"),
						rs.getString("publication"), rs.getInt("year"), rs.getString("image"),
						rs.getString("description"), rs.getInt("copies"), rs.getInt("availableBookCopies"), rs.getString("rackNo"));
			}
		}, categoryId, id);
		return (list != null && list.size() == 1) ? list.get(0) : null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.pk.booklibrary.dao.UserDao#addEducation(int,
	 * org.pk.booklibrary.model.Education)
	 */
	@Override
	public boolean addEducation(int id, Education education) {
		String SQL = "{CALL addEducation(?, ?, ?, ?, ?, ?)}";
		return jdbcTemplateObject.update(SQL, new Object[] { id, education.getDegree(), education.getCollege(),
				education.getBoard(), education.getPercentage(), education.getYear() }) == 1 ? true : false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.pk.booklibrary.dao.UserDao#getEducationById(int)
	 */
	@Override
	public Education getEducationById(int id) {

		String SQL = "{CALL getEducationById(?)}";
		List<Education> list = jdbcTemplateObject.query(SQL, new RowMapper<Education>() {
			@Override
			public Education mapRow(java.sql.ResultSet rs, int numRow) throws SQLException {
				return new Education(rs.getInt("educationId"), rs.getInt("userId"), rs.getString("degree"),
						rs.getString("college"), rs.getString("board"), rs.getFloat("percentage"), rs.getInt("year"));
			}
		}, id);
		return (list != null && list.size() == 1) ? list.get(0) : null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.pk.booklibrary.dao.UserDao#getEducationListByUserId(int)
	 */
	@Override
	public List<Education> getEducationListByUserId(int userId) {
		String SQL = "{CALL getEducationListByUserId(?)}";
		List<Education> list = jdbcTemplateObject.query(SQL, new RowMapper<Education>() {
			@Override
			public Education mapRow(java.sql.ResultSet rs, int numRow) throws SQLException {
				return new Education(rs.getInt("educationId"), rs.getInt("userId"), rs.getString("degree"),
						rs.getString("college"), rs.getString("board"), rs.getFloat("percentage"), rs.getInt("year"));
			}
		}, userId);
		return list;
	}

	@Override
	public List<IssuedBook> getIssuedBooksByUserId(int userId) {
		String SQL = "{CALL getIssuedBooksByUserId(?)}";
		List<IssuedBook> list = jdbcTemplateObject.query(SQL, new RowMapper<IssuedBook>() {
			@Override
			public IssuedBook mapRow(java.sql.ResultSet rs, int numRow) throws SQLException {
				IssuedBook ib = new IssuedBook();
				ib.setBookIssueId(rs.getInt("bookIssueId"));
				ib.setBookId(rs.getInt("bookId"));
				ib.setBookCategory(getBookCategoryById(rs.getInt("categoryId")));
				ib.setTitle(rs.getString("title"));
				ib.setAuthor(rs.getString("author"));
				ib.setISBN(rs.getString("ISBN"));
				ib.setPublication(rs.getString("publication"));
				ib.setYear(rs.getInt("year"));
				ib.setImage(rs.getString("image"));
				ib.setDescription(rs.getString("description"));
				ib.setCopies(rs.getInt("copies"));
				ib.setAvailableCopies( rs.getInt("availableBookCopies"));
				ib.setUserId(rs.getInt("userId"));
				ib.setIssuedDateTime(rs.getTimestamp("issueDateTime"));
				ib.setIssuedBy(rs.getInt("issuedBy"));
				ib.setLeagleReturnDateTime(rs.getTimestamp("leagleReturnDateTime"));
				ib.setActualReturnDateTime(rs.getTimestamp("actualReturnDateTime"));
				ib.setComment(rs.getString("comment"));
				ib.setStatus(BookIssueStatus.getBookIssueStatus(rs.getString("status")));
				return ib;
			}
		}, userId);
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.pk.booklibrary.dao.UserDao#getIssuedBooks()
	 */
	@Override
	public List<IssuedBook> getIssuedBooks() {
		String SQL = "{CALL getIssuedBooks()}";
		List<IssuedBook> list = jdbcTemplateObject.query(SQL, new RowMapper<IssuedBook>() {
			@Override
			public IssuedBook mapRow(java.sql.ResultSet rs, int numRow) throws SQLException {
				IssuedBook ib = new IssuedBook();
				ib.setBookIssueId(rs.getInt("bookIssueId"));
				ib.setBookId(rs.getInt("bookId"));
				ib.setBookCategory(getBookCategoryById(rs.getInt("categoryId")));
				ib.setTitle(rs.getString("title"));
				ib.setAuthor(rs.getString("author"));
				ib.setISBN(rs.getString("ISBN"));
				ib.setPublication(rs.getString("publication"));
				ib.setYear(rs.getInt("year"));
				ib.setImage(rs.getString("image"));
				ib.setDescription(rs.getString("description"));
				ib.setCopies(rs.getInt("copies"));
				ib.setAvailableCopies( rs.getInt("availableBookCopies"));
				ib.setUserId(rs.getInt("userId"));
				ib.setUser(getUserDetails(rs.getInt("userId")));
				ib.setIssuedDateTime(rs.getTimestamp("issueDateTime"));
				ib.setIssuedBy(rs.getInt("issuedBy"));
				ib.setLeagleReturnDateTime(rs.getTimestamp("leagleReturnDateTime"));
				ib.setActualReturnDateTime(rs.getTimestamp("actualReturnDateTime"));
				ib.setComment(rs.getString("comment"));
				ib.setStatus(BookIssueStatus.getBookIssueStatus(rs.getString("status")));
				return ib;
			}
		});
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.pk.booklibrary.dao.UserDao#updateBookImage(int,
	 * java.lang.String)
	 */
	@Override
	public boolean updateBookImage(int bookId, String imageName) {
		String SQL = "{CALL updateBookImage(?, ?)}";
		return jdbcTemplateObject.update(SQL, new Object[] { bookId, imageName }) == 1 ? true : false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.pk.booklibrary.dao.UserDao#issueBook(org.pk.booklibrary.model.
	 * IssuedBook)
	 */
	@Override
	public boolean issueBook(IssuedBook issueBook) {
		String SQL = "{CALL issueBook(?, ?)}";
		return jdbcTemplateObject.update(SQL, new Object[] { issueBook.getBookId(), issueBook.getUserId() }) == 1 ? true
				: false;
	}

	/**
	 * @param bookId
	 * @param userId
	 * @return
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.pk.booklibrary.dao.UserDao#isBookIssues(int, int)
	 */
	@Override
	public boolean isBookIssued(int bookId, int userId) {
		String SQL = "{CALL isBookIssued(?, ?)}";
		List<Boolean> list = jdbcTemplateObject.query(SQL, new RowMapper<Boolean>() {
			@Override
			public Boolean mapRow(java.sql.ResultSet rs, int numRow) throws SQLException {
				return true;
			}
		}, new Object[] { bookId, userId });
		return (list != null && list.size() == 1) ? list.get(0) : Boolean.FALSE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.pk.booklibrary.dao.UserDao#deleteBook(int)
	 */
	@Override
	public boolean deleteBook(int bookId) {
		String SQL = "delete from book where bookId =" + bookId;
		return jdbcTemplateObject.update(SQL) == 1 ? true : false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.pk.booklibrary.dao.UserDao#deleteUser(int)
	 */
	@Override
	public boolean deleteUser(int userId) {
		String SQL = "delete from user where userId =" + userId + " AND userType != 'ADMIN'";
		return jdbcTemplateObject.update(SQL) == 1 ? true : false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.pk.booklibrary.dao.UserDao#registerFine(int, double,
	 * java.lang.String)
	 */
	@Override
	public boolean registerFine(int bookIssueId, double amount, String comment) {
		String SQL = "{CALL registerFine(?, ?, ?)}";
		return jdbcTemplateObject.update(SQL, new Object[] { bookIssueId, amount, comment }) == 1 ? true : false;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.pk.booklibrary.dao.UserDao#requestForRenewal(int 
	 * java.lang.String)
	 */
	@Override
	public boolean requestForRenewal(int userId, int bookIssueId) {
		String SQL = "{CALL requestForRenewal(?,?)}";
		return jdbcTemplateObject.update(SQL, new Object[] { userId, bookIssueId}) == 1 ? true : false;
	}

	@Override
	public List<Fine> getFine(int bookIssueId) {
		// TODO Auto-generated method stub
		String SQL = "{CALL getFine(?)}";
		List<Fine> list = jdbcTemplateObject.query(SQL, new RowMapper<Fine>() {
			@Override
			public Fine mapRow(java.sql.ResultSet rs, int numRow) throws SQLException {
				Fine fn = new Fine();
				/*fn.setBookIssueId(rs.getInt("bookIssueId"));*/
				fn.setTitle(rs.getString("title"));
				fn.setFineAmount(rs.getDouble("fineAmount"));
				fn.setComment(rs.getString("comment"));
				/*fn.setDateTime(rs.getString("dateTime"));*/
				return fn;
			}
		}, bookIssueId);
		return list;
	}

}