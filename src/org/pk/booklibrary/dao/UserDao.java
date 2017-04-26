package org.pk.booklibrary.dao;

import java.util.List;

import org.pk.booklibrary.model.Book;
import org.pk.booklibrary.model.BookCategory;
import org.pk.booklibrary.model.Dashboard;
import org.pk.booklibrary.model.Education;
import org.pk.booklibrary.model.Fine;
import org.pk.booklibrary.model.IssuedBook;
import org.pk.booklibrary.model.User;

/**
 * @author SHREE
 * 
 */
public interface UserDao {

	/**
	 * @return
	 */
	Dashboard getDashboardData();

	/**
	 * @param userType
	 * @return
	 */
	List<User> getUsersByUserType(String userType);

	/**
	 * @param user
	 * @return
	 */
	boolean registerUser(User user);

	/**
	 * @param userId
	 * @return
	 */
	User getUserDetails(int userId);

	/**
	 * @param userId
	 * @param userStatus
	 * @return
	 */
	boolean updateUserStatus(int userId, String userStatus);

	/**
	 * @param userId
	 * @param user
	 * @return
	 */
	boolean updateUser(int userId, User user);

	/**
	 * @param userId
	 * @param imageName
	 * @return
	 */
	boolean updateUserProfilePic(int userId, String imageName);

	/**
	 * @param bookCategory
	 * @return boolean
	 */
	boolean addBookCategory(BookCategory bookCategory);

	/**
	 * @return
	 */
	List<BookCategory> getBookCategories();

	/**
	 * @param id
	 * @return
	 */
	BookCategory getBookCategoryById(int id);

	/**
	 * @param book
	 * @return
	 */
	boolean addBook(Book book);

	/**
	 * @param categoryId
	 * @return
	 */
	List<Book> getBooksByCategoryId(int categoryId);

	/**
	 * @param title
	 * @param autor
	 * @param publication
	 * @param category
	 * @return
	 */
	List<Book> searchBooks(String title, String autor, String publication, String category);

	/**
	 * @param categoryId
	 * @param bookId
	 * @return
	 */
	Book getBookById(int categoryId, int bookId);

	/**
	 * @param education
	 * @return
	 */
	boolean addEducation(int id, Education education);

	/**
	 * @param id
	 * @return
	 */
	Education getEducationById(int id);

	/**
	 * @param id
	 * @return
	 */
	List<Education> getEducationListByUserId(int id);

	/**
	 * @param token
	 * @return
	 */
	List<IssuedBook> getIssuedBooksByUserId(int token);

	/**
	 * @return
	 */
	List<IssuedBook> getIssuedBooks();

	/**
	 * @param bookId
	 * @param imageName
	 * @return
	 */
	boolean updateBookImage(int bookId, String imageName);

	/**
	 * @param bookId
	 * @param userId
	 * @return
	 */
	public boolean isBookIssued(int bookId, int userId);

	/**
	 * @param issuedBook
	 * @return
	 */
	boolean issueBook(IssuedBook issuedBook);

	/**
	 * @param id
	 * @return
	 */
	boolean deleteBook(int id);

	/**
	 * @param id
	 * @return
	 */
	boolean deleteUser(int id);

	/**
	 * @param bookIssueId
	 * @param amount
	 * @param comment
	 * @return
	 */
	boolean registerFine(int bookIssueId, double amount, String comment);
	
	
	/**
	 * @param userId
	 * @param bookIssueId
	 * @return
	 */
	boolean requestForRenewal(int userId, int bookIssueId);
	
	/**
	 * @param bookIssueId
	 * @return
	 */
	List<Fine> getFine(int bookIssueId);
}