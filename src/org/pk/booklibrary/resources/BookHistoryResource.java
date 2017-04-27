package org.pk.booklibrary.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.pk.booklibrary.constants.GlobalConstants;
import org.pk.booklibrary.dao.UserDao;
import org.pk.booklibrary.model.IssuedBook;
import org.pk.booklibrary.model.common.Message;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * resource for book history
 * 
 * @author PKORP
 * @since 26/04/2017
 */
@Path("books_history")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public final class BookHistoryResource {

	@Autowired
	UserDao userDao;

	@HeaderParam("token")
	int token;

	private Logger logger = Logger.getLogger(BookHistoryResource.class);

	/**
	 * @param categoryId
	 * @return all books by categoryId
	 */
	@GET
	@Path("{id}")
	public Response getBooksByCategoryId(@PathParam("id") int userId) {
		Message message = null;
		logger.debug("User Id " + userId);
		List<IssuedBook> list = userDao.getIssuedBooksByUserId(userId);
		if (list == null || list.isEmpty()) {
			message = new Message(false, GlobalConstants.NO_RECORD, null);
		} else {
			message = new Message(true, null, list);
		}
		return Response.status(Status.OK).entity(message).build();
	}
}