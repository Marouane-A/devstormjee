package tn.devstorm.rest;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxException;

import tn.devstorm.services.ImageServiceRemote;


@Path("/images")
@RequestScoped
public class ImageRessource {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@Inject
	ImageServiceRemote ejbImages;

	@GET
	public void images(){
		
	}
	
	@GET @Path("/authorization")
	@Consumes(MediaType.APPLICATION_JSON)
	public String authorization() throws IOException, DbxException {
		return ejbImages.authorization();
	}

}
