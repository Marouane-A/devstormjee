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
import tn.devstorm.services.TriLocal;

@Path("/tri")
@RequestScoped
public class TriServices {
	
	@GET
	public void tri(){}

	@Inject
	TriLocal tl;
	
	@GET @Path("/priceLowerThen/{l}")
    @Produces({MediaType.APPLICATION_JSON})
	public List<Product> priceLowerThen(@PathParam("l") int l) {
		return tl.priceLowerThen(l);
	}
	
	@GET @Path("/priceGreaterThen/{g}")
    @Produces({MediaType.APPLICATION_JSON})
	public List<Product> priceGreaterThen(@PathParam("g") int g) {
		return tl.priceGreaterThen(g);
	}
	
	@GET @Path("/priceBetween/{l}/{g}")
    @Produces({MediaType.APPLICATION_JSON})
	public List<Product> priceBetween(@PathParam("l") int l, @PathParam("g") int g) {
		return tl.priceBetween(l,g);
	}
}
