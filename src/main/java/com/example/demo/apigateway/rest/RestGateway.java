package com.example.demo.apigateway.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.demo.apigateway.proxy.MyProxyProva;

@Path("/gateway")
public class RestGateway {
	
	@Inject
	private MyProxyProva proxy;
	
	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON,
			MediaType.APPLICATION_XML,
			MediaType.TEXT_PLAIN})
	public Response getAll() {
		return proxy.getAll();
	}
	
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON,
			MediaType.APPLICATION_XML,
			MediaType.TEXT_PLAIN})
	public Response getByID(@PathParam("id") String id) {
		return proxy.getByID(id);
	}
	
}
