package tn.devstorm.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.devstorm.services.TwitterServiceLocal;


@Path("/twit")
@RequestScoped
public class TwitterResource {
	@Inject
	TwitterServiceLocal ejbtw;
	
	@GET
	@Path("/add/{prodId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response twitPost(@PathParam("prodId")int prodId) {
		ejbtw.twitte(prodId);
		return Response.status(Status.OK).build();
		
	}
}
