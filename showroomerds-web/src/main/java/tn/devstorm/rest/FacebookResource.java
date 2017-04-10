package tn.devstorm.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
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
	@Path("/interaction/{prodId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String fbgetInteraction(@PathParam("prodId")int prodId){
		long x= ejbfb.getCountComments(prodId);
		long y=  ejbfb.getCountLikes(prodId);
		long z=  ejbfb.getCountShares(prodId);
		return "Comments = "+x+" Likes = "+y+"Shares = "+z;
	}
	

}
