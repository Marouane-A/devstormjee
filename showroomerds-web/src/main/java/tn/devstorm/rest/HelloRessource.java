package tn.devstorm.rest;

import java.util.OptionalDouble;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import tn.devstorm.services.StatsServiceRemote;

@Path("/sumRate")
@RequestScoped
public class HelloRessource {
	@Inject
	StatsServiceRemote ejb;
	
	
    @GET
    public double sumOfRates(){
    	return ejb.sumOfRates();
    }
}
