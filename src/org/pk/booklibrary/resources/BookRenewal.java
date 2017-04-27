package org.pk.booklibrary.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.pk.booklibrary.dao.UserDao;
import org.pk.booklibrary.model.common.Message;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author PKORP
 * @since 26/04/2017
 * 
 */
@Path("book_renewal")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookRenewal {

	@Autowired
	UserDao userDao;

	private Logger logger = Logger.getLogger(BookRenewal.class);

	/**
	 * @param userId
	 * @param bookIssueId
	 * @return
	 */
	@POST
	public Response requestForRenewal(@QueryParam("userId") int userId, @QueryParam("bookIssueId") int bookIssueId) {
		Message message = null;
		logger.info("Book Renewal userId=>" + userId);
		logger.info("Book Renewal bookIssueId=>" + bookIssueId);

		// requestForRenewal this function will do task of renewal
		// userId for it
		boolean result = userDao.requestForRenewal(userId, bookIssueId);
		if (result) {
			message = new Message(true, "Book Renewaled successfully.", null);
		} else {
			message = new Message(false, "Error in renewal", null);
		}
		return Response.status(Status.OK).entity(message).build();
	}
}