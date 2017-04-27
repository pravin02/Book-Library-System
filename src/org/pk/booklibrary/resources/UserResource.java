package org.pk.booklibrary.resources;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.pk.booklibrary.constants.GlobalConstants;
import org.pk.booklibrary.dao.LoginDao;
import org.pk.booklibrary.dao.UserDao;
import org.pk.booklibrary.model.User;
import org.pk.booklibrary.model.UserStatus;
import org.pk.booklibrary.model.UserType;
import org.pk.booklibrary.model.common.Message;
import org.pk.booklibrary.utils.AppUtils;
import org.pk.booklibrary.utils.DateTimeUtils;
import org.pk.booklibrary.utils.FileUtils;
import org.pk.booklibrary.utils.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author PKCORP
 * @since 26/04/2017
 * 
 */
@Path("users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

	@Autowired
	UserDao userDao;

	@Autowired
	LoginDao loginDao;

	@HeaderParam("token")
	String token;

	@Context
	UriInfo uriInfo;

	@Autowired
	private ServletContext servletContext;

	private Logger logger = Logger.getLogger(UserResource.class);

	/**
	 * @param userType
	 * @return returns users list by user type
	 */
	@GET
	public Response getUsersList(@QueryParam("userType") String userType) {
		Message message = null;
		List<User> list = userDao.getUsersByUserType(userType);
		if (list != null) {
			message = new Message(true, null, list);
		} else {
			message = new Message(false, "Error in fetching user details.", null);
		}
		return Response.status(Status.OK).entity(message).build();
	}

	/**
	 * @param id
	 * @return user details by userId
	 */
	@GET
	@Path("/{id}")
	public Response getUserDetails(@PathParam("id") int id) {
		Message message = null;
		User user = userDao.getUserDetails(id);
		if (user != null) {
			message = new Message(true, null, user);
		} else {
			message = new Message(false, "Error in fetching user details.", null);
		}
		return Response.status(Status.OK).entity(message).build();
	}

	/**
	 * @param user
	 * @return Response
	 */
	@POST
	public Response registerUser(User user) {
		Message message = null;

		/*
		 * validating user details
		 */
		if (TextUtils.isEmpty(user.getFullName())) {
			message = new Message(false, "Please enter Full Name.", null);
		} else if (TextUtils.isEmpty(user.getGender())) {
			message = new Message(false, "Please select Gender.", null);
		} else if (!user.getGender().equals("MALE") && !user.getGender().equals("FEMALE")) {
			message = new Message(false, "Gender should be MALE or FEMALE.", null);
		} else if (TextUtils.isEmpty(user.getDob())) {
			message = new Message(false, "Please enter DOB.", null);
		} else if (TextUtils.isEmpty(user.getMobileNo())) {
			message = new Message(false, "Please enter Mobile Number.", null);
		} else if (!AppUtils.isValidMobileNumber(user.getMobileNo())) {
			message = new Message(false, "Mobile Number must be 10 digit.", null);
		} else if (!AppUtils.isEmailValid(user.getEmailId())) {
			message = new Message(false, "Please enter valid EmailId.", null);
		} else if (TextUtils.isEmpty(user.getCountry())) {
			message = new Message(false, "Please enter Country Name.", null);
		} else if (TextUtils.isEmpty(user.getState())) {
			message = new Message(false, "Please enter State Name.", null);
		} else if (TextUtils.isEmpty(user.getCity())) {
			message = new Message(false, "Please enter City Name.", null);
		} else if (TextUtils.isEmpty(user.getPassword())) {
			message = new Message(false, "Please enter Password.", null);
		} else if (user.getPassword().length() < 5 || user.getPassword().length() > 15) {
			message = new Message(false, "Password should be 5-15 characters.", null);
		} else if (TextUtils.isEmpty(user.getAddress())) {
			message = new Message(false, "Please enter Address.", null);
		} else if (user.getUserType() == null) {
			message = new Message(false, "Please select UserType.", null);
		} else if (!user.getUserType().name().equals(UserType.STAFF.name())
				&& !user.getUserType().name().equals(UserType.STUDENT.name())) {
			message = new Message(false, "Invalid valid -User Type.", null);
		} else if (TextUtils.isEmpty(user.getDesignation())) {
			message = new Message(false, "Please enter Designation.", null);
		} else {
			String res = loginDao.isMobileOrEmailAllreadyExists(user.getEmailId(), user.getMobileNo());
			if (res != null) {
				message = new Message(false, res, null);
				return Response.status(Status.OK).entity(message).build();
			}

			boolean result = userDao.registerUser(user);
			if (result)
				message = new Message(true, "User Registered Successfully.", null);
			else
				message = new Message(false, "Error while Registering User.", null);
		}
		return Response.status(Status.OK).entity(message).build();
	}

	/**
	 * @param id
	 * @param uploadedInputStream
	 * @param fileDetail
	 * @param password
	 * @return writing profile picture to books directory and updating record by
	 *         userId
	 */
	@POST
	@Path("/{id}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadProfilePic(@PathParam("id") int id, @FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail, @FormDataParam("password") String password) {
		Message message = null;
		String fileName = fileDetail.getFileName();
		String fileExtension = FileUtils.getFileExtension(fileName);

		// String fileNamePath = servletContext.getRealPath("") + File.separator
		// + GlobalConstants.PROFILE_DIR, fileName,

		if (FileUtils.isValidFileExtension(fileExtension)) {
			String finalName = DateTimeUtils.getCurrentDateTimeForFile().concat(".").concat(fileExtension);
			logger.info("final Name " + finalName);
			String BASEPATH = servletContext.getRealPath("") + File.separator + GlobalConstants.PROFILE_DIR;
			if (FileUtils.writeToFile(uploadedInputStream, BASEPATH, fileName, finalName)) {

				if (userDao.updateUserProfilePic(id, finalName)) {
					message = new Message(true, GlobalConstants.UPDATE_SUCCESS, finalName);
				} else {
					message = new Message(false, GlobalConstants.UPDATE_FAILURE, null);
				}
			} else {
				message = new Message(false, GlobalConstants.UPDATE_FAILURE, null);
			}
		} else {
			message = new Message(false, GlobalConstants.INVALID_FILE_FORMAT + " " + GlobalConstants.IMAGE_ALLOWED,
					null);
		}
		return Response.status(Status.OK).entity(message).build();
	}

	/**
	 * @param id
	 * @param user
	 * @return updating user status
	 */
	@PUT
	@Path("status/{id}")
	public Response updateUserStatus(@PathParam("id") int id, User user) {
		Message message = null;
		if (user.getUserStatus() == null) {
			message = new Message(false, "Provided status is invalid.", null);
			return Response.status(Status.OK).entity(message).build();
		}
		String status = UserStatus.INACTIVE.name();
		switch (user.getUserStatus()) {
		case ACTIVE:
			status = UserStatus.INACTIVE.name();
			break;
		case INACTIVE:
			status = UserStatus.ACTIVE.name();
			break;
		case DELETED:
			status = UserStatus.DELETED.name();
			break;
		}
		if (userDao.updateUserStatus(id, status)) {
			message = new Message(true, GlobalConstants.UPDATE_SUCCESS, null);
		} else {
			message = new Message(false, GlobalConstants.UPDATE_FAILURE, null);
		}
		return Response.status(Status.OK).entity(message).build();
	}

	/**
	 * @param id
	 * @param user
	 * @return updating user details
	 */
	@PUT
	@Path("/{id}")
	public Response updateUser(@PathParam("id") int id, User user) {
		Message message = null;
		logger.info(user);
		if (!AppUtils.isValidMobileNumber(user.getMobileNo())) {
			message = new Message(false, "Mobile Number must be 10 digit.", null);
		} else if (TextUtils.isEmpty(user.getAddress())) {
			message = new Message(false, "Please enter Address.", null);
		}

		else if (userDao.updateUser(id, user)) {
			message = new Message(true, GlobalConstants.UPDATE_SUCCESS, null);
		} else {
			message = new Message(false, GlobalConstants.UPDATE_FAILURE, null);
		}
		return Response.status(Status.OK).entity(message).build();
	}

	/**
	 * @param id
	 * @return delete user record from system
	 */
	@DELETE
	@Path("{id}")
	public Response deleteUser(@PathParam("id") int id) {
		Message message = null;
		if (id > 0) {
			if (userDao.deleteUser(id)) {
				message = new Message(true, GlobalConstants.DELETE_SUCCESS, null);
			} else {
				message = new Message(false, GlobalConstants.DELETE_FAILURE, null);
			}
		} else {
			message = new Message(false, "Invalid Users Id", null);
		}
		return Response.status(Status.OK).entity(message).build();
	}
}