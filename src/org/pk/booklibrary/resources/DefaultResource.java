package org.pk.booklibrary.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.pk.booklibrary.model.common.AppConstants;
import org.pk.booklibrary.model.common.Message;

@Path("/")
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public class DefaultResource {
	private Logger logger = Logger.getLogger(DefaultResource.class);
	/**
	 * @return Response default API Resource application details
	 */	
	@GET
	public Response get() {
		logger.info(AppConstants.appName + " " + AppConstants.appVersion);
		return Response
				.status(Status.OK)
				.entity(new Message(true, AppConstants.appName + " "
						+ AppConstants.appVersion, null)).build();
	}
}