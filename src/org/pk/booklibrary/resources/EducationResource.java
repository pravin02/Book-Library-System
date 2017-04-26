package org.pk.booklibrary.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
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
import org.pk.booklibrary.model.Education;
import org.pk.booklibrary.model.common.Message;
import org.pk.booklibrary.utils.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author SHREE
 * 
 */
@Path("/educations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EducationResource {

	@Autowired
	UserDao userDao;

	@HeaderParam("token")
	int token;

	private Logger logger = Logger.getLogger(EducationResource.class);

	/**
	 * @param id
	 * @return
	 */
	@GET
	public Response getEducationListByUserId() {
		Message message;
		logger.info("Token " + token);
		List<Education> object = userDao.getEducationListByUserId(token);
		if (object == null || object.size() == 0) {
			message = new Message(false, GlobalConstants.NO_RECORD, null);
		} else {
			message = new Message(true, null, object);
		}
		return Response.status(Status.OK).entity(message).build();
	}

	/**
	 * @param id
	 * @return
	 */
	@GET
	@Path("{id}")
	public Response getEducationById(@PathParam("id") int id) {
		Message message;
		Education object = userDao.getEducationById(id);
		if (object == null) {
			message = new Message(false, GlobalConstants.NO_RECORD, null);
		} else {
			message = new Message(true, null, object);
		}
		return Response.status(Status.OK).entity(message).build();
	}

	/**
	 * @param user
	 * @return Response
	 */
	@POST
	public Response addEducation(Education education) {
		logger.info("addEducation: id = " + token + "\n " + education);
		Message message = null;
		if (token == 0) {
			message = new Message(false, "Invalid UserId.", null);
		} else if (TextUtils.isEmpty(education.getDegree())) {
			message = new Message(false, "Please enter Degree.", null);
		} else if (TextUtils.isEmpty(education.getCollege())) {
			message = new Message(false, "Please enter College Name.", null);
		} else if (TextUtils.isEmpty(education.getBoard())) {
			message = new Message(false, "Please enter Board.", null);
		} else if (education.getPercentage() > 100.0 || education.getPercentage() == 0.0) {
			message = new Message(false, "Please enter Percentage.", null);
		} else if (education.getYear() == 0) {
			message = new Message(false, "Please enter passing Year.", null);
		} else {
			boolean result = userDao.addEducation(token, education);
			if (result)
				message = new Message(true, GlobalConstants.ADD_SUCCESS, null);
			else
				message = new Message(false, GlobalConstants.ADD_FAULURE, null);
		}
		return Response.status(Status.OK).entity(message).build();
	}
}