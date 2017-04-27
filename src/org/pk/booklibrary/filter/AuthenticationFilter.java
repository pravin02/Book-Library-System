package org.pk.booklibrary.filter;

import java.util.List;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import org.pk.booklibrary.model.common.Message;

/**
 * This class created for authentication purpose before forwarding request to
 * resource.
 * 
 * @author PKORP
 * @since 26/04/2017
 */
@Provider
public class AuthenticationFilter implements ContainerRequestFilter {
	/**
	 * This method gets called internally whenever client requests to any
	 * resource.
	 * 
	 * @see javax.ws.rs.container.ContainerRequestFilter#filter(javax.ws.rs.container.ContainerRequestContext)
	 */
	@Override
	public void filter(ContainerRequestContext requestContext) {
		boolean isError = false;
		String absoluteUrl = requestContext.getUriInfo().getPath();
		String AUTH_URL = "authentication";
		String REGISTER_URL = "user/register";
		if (absoluteUrl.equalsIgnoreCase("") || absoluteUrl.equalsIgnoreCase(AUTH_URL)
				|| absoluteUrl.equalsIgnoreCase(REGISTER_URL)) {
			return;
		}
		try {
			String token;
			List<String> headers = requestContext.getHeaders().get("token");
			if (headers != null) {
				if (headers.size() > 0) {
					token = headers.get(0);

					if (token.equals("0"))
						isError = true;
				} else
					isError = true;
			} else
				isError = true;
		} catch (Exception e) {
			e.printStackTrace();
			isError = true;
		}
		if (isError) {
			Message message = new Message(false, "Unautherised user", null);
			requestContext.abortWith(Response.status(Status.UNAUTHORIZED).entity(message).build());
		}
	}
}