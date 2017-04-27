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
 * UserDao interface
 * 
 * @author PKORP
 * @since 26/04/2017
 */
public interface UserDao {

	/**
	 * @return dashboard data
	 */
	Dashboard getDashboardData();

	/**
	 * @param userType
	 * @return users list by user type
	 */
	List<User> getUsersByUserType(String userType);

	/**
	 * @param user
	 * @return registers new users in system
	 */
	boolean registerUser(User user);

	/**
	 * @param userId
	 * @return returns user details by userId
	 */
	User getUserDetails(int userId);

	/**
	 * @param userId
	 * @param userStatus
	 * @return update user status on given userId
	 */
	boolean updateUserStatus(int userId, String userStatus);

	/**
	 * @param userId
	 * @param user
	 * @return update user details against userId
	 */
	boolean updateUser(int userId, User user);

	/**
	 * @param userId
	 * @param imageName
	 * @return boolean update user profile picture
	 */
	boolean updateUserProfilePic(int userId, String imageName);

	/**
	 * @param bookCategory
	 * @return boolean add book category
	 */
	boolean addBookCategory(BookCategory bookCategory);

	/**
	 * @return enlisted book categories
	 */
	List<BookCategory> getBookCategories();

	/**
	 * @param id
	 * @return book category details by categoryId
	 */
	BookCategory getBookCategoryById(int id);

	/**
	 * @param book
	 * @return add new book to system
	 */
	boolean addBook(Book book);

	/**
	 * @param categoryId
	 * @return get books by categoryId
	 */
	List<Book> getBooksByCategoryId(int categoryId);

	/**
	 * @param title
	 * @param autor
	 * @param publication
	 * @param category
	 * @return books list which satisfies search criteria
	 */
	List<Book> searchBooks(String title, String autor, String publication, String category);

	/**
	 * @param categoryId
	 * @param bookId
	 * @return book details by bookId
	 */
	Book getBookById(int categoryId, int bookId);

	/**
	 * @param education
	 * @return add new education entries
	 */
	boolean addEducation(int id, Education education);

	/**
	 * @param id
	 * @return returns education details by educationId
	 */
	Education getEducationById(int id);

	/**
	 * @param id
	 * @return education list of particular user
	 */
	List<Education> getEducationListByUserId(int id);

	/**
	 * @param token
	 * @return returns issued books by userId
	 */
	List<IssuedBook> getIssuedBooksByUserId(int token);

	/**
	 * @return returns all issued books
	 */
	List<IssuedBook> getIssuedBooks();

	/**
	 * @param bookId
	 * @param imageName
	 * @return boolean - updates book image by bookId
	 */
	boolean updateBookImage(int bookId, String imageName);

	/**
	 * @param bookId
	 * @param userId
	 * @return boolean if book issued
	 */
	public boolean isBookIssued(int bookId, int userId);

	/**
	 * @param issuedBook
	 * @return to register book issue
	 */
	boolean issueBook(IssuedBook issuedBook);

	/**
	 * @param id
	 * @return deletes book from system
	 */
	boolean deleteBook(int id);

	/**
	 * @param id
	 * @return delete user from system
	 */
	boolean deleteUser(int id);

	/**
	 * @param bookIssueId
	 * @param amount
	 * @param comment
	 * @return registers fine against issued book to user
	 */
	boolean registerFine(int bookIssueId, double amount, String comment);

	/**
	 * @param userId
	 * @param bookIssueId
	 * @return register request for renewal
	 */
	boolean requestForRenewal(int userId, int bookIssueId);

	/**
	 * @param bookIssueId
	 * @return fine list for issued book
	 */
	List<Fine> getFine(int bookIssueId);
}