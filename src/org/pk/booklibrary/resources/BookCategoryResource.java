package org.pk.booklibrary.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.pk.booklibrary.constants.GlobalConstants;
import org.pk.booklibrary.dao.UserDao;
import org.pk.booklibrary.model.BookCategory;
import org.pk.booklibrary.model.common.Message;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author SHREE
 * 
 */
@Path("categories")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookCategoryResource {
	@Autowired
	UserDao userDao;

	private Logger logger = Logger.getLogger(BookCategoryResource.class);

	@POST
	public Response addBookCategory(BookCategory bookCategory) {
		Message message = null;
		// BookCategory bookCategory = new BookCategory(0, category,
		// description);
		logger.info("Book category message " + bookCategory);
		boolean result = userDao.addBookCategory(bookCategory);
		if (result) {
			message = new Message(true, GlobalConstants.ADD_SUCCESS, null);
		} else {
			message = new Message(false, GlobalConstants.ADD_FAULURE, null);
		}
		return Response.status(Status.OK).entity(message).build();
	}

	@GET
	public Response getAllCategories() {
		Message message = null;
		List<BookCategory> list = userDao.getBookCategories();

		if (list == null) {
			message = new Message(false, GlobalConstants.NO_RECORD, null);
		} else {
			message = new Message(true, null, list);
		}
		return Response.status(Status.OK).entity(message).build();

	}

	@GET
	@Path("{id}")
	public Response getBookCategoryById(@PathParam("id") int id) {
		Message message = null;

		BookCategory object = userDao.getBookCategoryById(id);
		if (object == null) {
			message = new Message(false, GlobalConstants.NO_RECORD, null);
		} else {
			message = new Message(true, null, object);
		}
		return Response.status(Status.OK).entity(message).build();

	}

	/*
	 * @GET
	 * 
	 * @Path("{categoryId}/books/{id}") public Response
	 * geBookById(@PathParam("categoryId") int categoryId, @PathParam("id") int
	 * id) { Message message = null; logger.debug("categoryId " + categoryId);
	 * logger.debug("bookId " + id); Book object =
	 * userDao.getBookById(categoryId, id); if (object == null) { message = new
	 * Message(false, GlobalConstants.NO_RECORD, null); } else { message = new
	 * Message(true, null, object); } return
	 * Response.status(Status.OK).entity(message).build(); }
	 */

	@Path("{categoryId}/books")
	public BookResource getBookResource() {
		return new BookResource();
	}

}
