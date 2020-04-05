package com.example.demo.apigateway.proxy;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

@SessionScoped
public class ProxyProducer implements Serializable {

	private static final long serialVersionUID = -5834160495869799610L;
	
	@Inject
	@ConfigProperty(name = "microservice.prova.host.endpoint", defaultValue = "localhost")
	private String microserviceHost;

	@Produces
	public MyProxyProva proxyService() {
		final String url = "http://" + microserviceHost + ":8080/database/product";
		final Client client = ClientBuilder.newClient();
		final WebTarget target = client.target(url);
		final ResteasyWebTarget rtarget = (ResteasyWebTarget) target;
		final MyProxyProva svc = rtarget.proxy(MyProxyProva.class);
		return svc;
	}

}
