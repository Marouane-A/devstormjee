package tn.devstorm.rest;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tn.devstorm.services.MailLocal;


@Path("/mail")
@RequestScoped
public class MailServices {


	@GET 
	public void mail(){} 
	
	@Inject
	MailLocal ml;
	
	@GET @Path("/mailsend/{subject}")
    @Produces({MediaType.APPLICATION_JSON})
	public String mailsend(@PathParam("subject") String subject) {
		
		return ml.mailsend(subject);
	
	}
}
