package tn.devstorm.restclient;


import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.typicode.jsonplaceholder.Rate;

public class RateResouceClient {

	public static void main(String[] args) {
		RateResouceClient rrc=new RateResouceClient();
		System.out.println(rrc.getRate(2));

	}
	public List<Rate> getRates(){
		Client client = ClientBuilder.newClient();

		WebTarget baseURL = client.target("http://localhost:5000/api/Rate");
		List<Rate> rates = baseURL.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Rate>>() {});
		client.close();
		return rates;
		
	}
	public Rate getRate(int id) {
		Client client = ClientBuilder.newClient();
		
		
		WebTarget baseUrl = client.target("http://localhost:5000/api/Rate");
		WebTarget getRateURL=baseUrl.path(""+id);
		Response response = getRateURL.request(MediaType.APPLICATION_JSON).get();
		Rate rate=response.readEntity(Rate.class);
		//Rate sh =mapper.readValue(getRateURL.request(MediaType.APPLICATION_JSON).get(String.class), Rate.class);
		response.close();
		client.close();
		return rate;
		
	}
	
	public int deleteRate(int id){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("http://localhost:5000/api/Rate");
		WebTarget deleteRateURL=baseUrl.path(""+id);
		Response response=deleteRateURL.request().delete();
		return response.getStatus();
	}
	
	public int addRate(Rate rate){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("http://localhost:5000/api/Rate");
		Response response=baseUrl.request().post(Entity.entity(rate, MediaType.APPLICATION_JSON));
		
		return response.getStatus();
	}
	
	public int updateRate(Rate rate){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("http://localhost:5000/api/Rate");
		WebTarget updateRateURL=baseUrl.path(""+rate.getUserId());
		Response response=updateRateURL.request().put(Entity.entity(rate, MediaType.APPLICATION_JSON));
		
		return response.getStatus();
	}


}
