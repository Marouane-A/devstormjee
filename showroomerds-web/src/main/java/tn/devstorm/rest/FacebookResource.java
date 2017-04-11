package tn.devstorm.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.devstorm.services.FbServiceLocal;



@Path("/fb")
@RequestScoped
public class FacebookResource {
	@Inject
	FbServiceLocal ejbfb;
	
	@GET
	@Path("/post/{prodId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String fbPost(@PathParam("prodId")int prodId){
		return ejbfb.fbpostproduct(prodId);		
	}
	@GET
	@Path("/com/{id}/{text}")
	@Produces
	public Response fbAddCom(@PathParam("id") int prodId,@PathParam("text")String text){
		 ejbfb.fbCommentProd(prodId, text);
		return Response.status(Status.OK).build();			
	}
	@GET
	@Path("/comments/{prodId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response fbgetCommentCount(@PathParam("prodId")int prodId){
		long x= ejbfb.getCountComments(prodId);
		 JsonObject json = Json.createObjectBuilder().add("comment_count", x).build();		 
		 return Response.ok(json).build();
	}
	@GET
	@Path("/likes/{prodId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response fbgetLikesCount(@PathParam("prodId")int prodId){
		long x= ejbfb.getCountLikes(prodId);
		JsonObject json = Json.createObjectBuilder().add("like_count", x).build();		 
		 return Response.ok(json).build();
	}
	@GET
	@Path("/shares/{prodId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response fbgetsharesCount(@PathParam("prodId")int prodId){
		long x=ejbfb.getCountShares(prodId);
		JsonObject json = Json.createObjectBuilder().add("share_count", x).build();		 
		 return Response.ok(json).build();
	}
	

}
