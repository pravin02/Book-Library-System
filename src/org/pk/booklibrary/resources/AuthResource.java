package org.pk.booklibrary.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.pk.booklibrary.dao.LoginDao;
import org.pk.booklibrary.model.User;
import org.pk.booklibrary.model.common.Message;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * resource for authentication
 * 
 * @author PKORP
 * @since 26/04/2017
 */

@Path("authentication")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthResource {

	/**
	 * loginDao is acting as a bridge between resource & database
	 */
	@Autowired
	LoginDao loginDao;
	/*
	 * Logger for logging DEBUG messages to files
	 */
	private Logger logger = Logger.getLogger(AuthResource.class);

	/**
	 * function for login
	 * 
	 * @param user
	 * @return Response
	 */
	@POST
	public Response login(User user) {
		User result = loginDao.loginUser(user.getEmailId(), user.getPassword());
		Message message = null;
		if (result == null)
			message = new Message(false, "Invalid userName or Password", null);
		else {
			switch (result.getUserStatus()) {
			case ACTIVE:
				message = new Message(true, null, result);
				break;
			case INACTIVE:
				message = new Message(false, "Your account id Deactivated. Please contact to your Admin", null);
				break;
			case DELETED:
				break;
			}
		}
		return Response.status(Status.OK).entity(message).build();
	}

	/**
	 * @param user
	 * @return Response
	 */
	@POST
	@Path("/admin")
	public Response loginAdmin(User user) {
		User result = loginDao.loginAdmin(user.getEmailId(), user.getPassword());
		Message message = null;
		if (result == null)
			message = new Message(false, "Invalid userName or Password", null);
		else
			message = new Message(true, null, result);
		return Response.status(Status.OK).entity(message).build();
	}

	/**
	 * @param id
	 * @param user
	 * @return
	 */
	@PUT
	@Path("/updatePassword/{id}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response updatePassword(@PathParam("id") int userId, @FormParam("oldPassword") String oldPassword,
			@FormParam("newPassword") String newPassword) {
		Message message = null;
		logger.info("userID " + userId);
		logger.info("oldPassword " + oldPassword);
		logger.info("newPassword " + newPassword);
		String result = loginDao.updatePassword(userId, oldPassword, newPassword);
		message = new Message(true, result, null);
		return Response.status(Status.OK).entity(message).build();
	}
}