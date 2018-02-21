package com.cjla.rest.services;

import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class WebService {

	private static final Logger LOG = Logger.getLogger(WebService.class.getName());

	@GET
	@Path("classes")
	@Produces(MediaType.APPLICATION_JSON)
	public String fetchClasses(String uid) {
		LOG.info("Executing operation fetchUserById");
		// User u = getUserRepo().get(uid);
		return "";
	}

}
