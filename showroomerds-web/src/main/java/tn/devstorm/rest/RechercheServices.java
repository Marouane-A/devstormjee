package tn.devstorm.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.typicode.jsonplaceholder.Product;

import tn.devstorm.services.RechercheLocal;

@Path("/recherche")
@RequestScoped
public class RechercheServices {
	
	@GET 
	public void recherche(){} 
	
	@Inject
	RechercheLocal rl;
	
	@GET @Path("/findByName/{nomP}")
    @Produces({MediaType.APPLICATION_JSON})
	public List<Product> findByName(@PathParam("nomP") String nomP) {
		return rl.findByName(nomP);
	}
	
	
	
	@GET @Path("/findByBrand/{brandP}")
    @Produces({MediaType.APPLICATION_JSON})
	public List<Product> findByBrand(@PathParam("brandP") String brandP) {
		return rl.findByBrand(brandP);
	}
	

	
	@GET @Path("/findByCategory/{categoryP}")
    @Produces({MediaType.APPLICATION_JSON})
	public List<Product> findByCategory(@PathParam("categoryP") String categoryP) {
		return rl.findByCategory(categoryP);
	}
	

	@GET @Path("/findGlobal/{critere}")
    @Produces({MediaType.APPLICATION_JSON})
	public List<Product> findGlobal(@PathParam("critere") String critere) {
		return rl.findGlobal(critere);
	}
	

}
