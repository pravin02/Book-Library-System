package org.pk.booklibrary.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.pk.booklibrary.dao.UserDao;
import org.pk.booklibrary.model.Dashboard;
import org.pk.booklibrary.model.common.Message;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author PKCORP
 * @since 26/04/2017
 * 
 */
@Path("dashboard")
@Produces(MediaType.APPLICATION_JSON)
public class DashboardResource {
	@Autowired
	UserDao userDao;

	@GET
	public Response getDashboardData() {
		Dashboard result = userDao.getDashboardData();
		Message message = null;
		if (result == null)
			message = new Message(false, "Error in getting Dashboard Data", null);
		else
			message = new Message(true, null, result);
		return Response.status(Status.OK).entity(message).build();
	}
}