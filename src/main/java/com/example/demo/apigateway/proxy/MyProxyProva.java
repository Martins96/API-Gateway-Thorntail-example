package com.example.demo.apigateway.proxy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public interface MyProxyProva {
	
	@Path("/{id}")
	@GET
	@Produces({MediaType.APPLICATION_JSON, 
		MediaType.APPLICATION_XML, 
		MediaType.TEXT_PLAIN})
	public Response getByID(@PathParam("id") String id);
	
	@GET
	@Path("/")
	@Produces({
		MediaType.APPLICATION_JSON,
		MediaType.APPLICATION_XML,
		MediaType.TEXT_PLAIN
	})
	public Response getAll();
}
