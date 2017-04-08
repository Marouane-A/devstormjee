package tn.devstorm.rest;



import java.util.List;
import java.util.OptionalDouble;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.typicode.jsonplaceholder.Product;

import tn.devstorm.services.StatsServiceRemote;

@Path("/stats")
@RequestScoped
public class HelloRessource {
	@Inject
	StatsServiceRemote ejbStats;
	
	@GET
	public void stats(){
		
	}
	@GET @Path("/sumOfRates")
    @Produces({MediaType.APPLICATION_JSON})
    public double sumOfRates(){
    	return ejbStats.sumOfRates();
    }
	@GET @Path("/averageRate")
    @Produces({MediaType.APPLICATION_JSON})
    public OptionalDouble averageRate(){
    	return ejbStats.averageRate();
    }
	@GET @Path("/sumOfRatesPerUser")
    @Produces({MediaType.APPLICATION_JSON})
    public double sumOfRatesPerUser(int id){
    	return ejbStats.sumOfRatesPerUser(id);
    }
	@GET @Path("/sumOfRatesPerProduct")
    @Produces({MediaType.APPLICATION_JSON})
    public double sumOfRatesPerProduct(int id){
    	return ejbStats.sumOfRatesPerProduct(id);
    }
	@GET @Path("/ProductsByMostQuantity")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Product> ProductsByMostQuantity(){
    	return ejbStats.ProductsByMostQuantity();
    }
	@GET @Path("/ProductsByMinQuantity")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Product> ProductsByMinQuantity(){
    	return ejbStats.ProductsByMinQuantity();
    }
	@GET @Path("/ProductsByMaxPrice")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Product> ProductsByMaxPrice(){
    	return ejbStats.ProductsByMaxPrice();
    }
	@GET @Path("/ProductsByMinPrice")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Product> ProductsByMinPrice(){
    	return ejbStats.ProductsByMinPrice();
    }
	@GET @Path("/ProductsByMaxInteraction")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Product> ProductsByMaxInteraction(){
    	return ejbStats.ProductsByMaxInteraction();
    }
	@GET @Path("/SumOfPurchases")
    @Produces({MediaType.APPLICATION_JSON})
    public double SumOfPurchases(){
    	return ejbStats.SumOfPurchases();
    }
	@GET @Path("/ProductBestOffer")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Product> ProductBestOffer(){
    	return ejbStats.ProductBestOffer();
    }
}
