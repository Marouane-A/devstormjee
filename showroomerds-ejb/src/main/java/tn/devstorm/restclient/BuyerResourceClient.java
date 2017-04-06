package tn.devstorm.restclient;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.typicode.jsonplaceholder.Buyer;

public class BuyerResourceClient {
	public static void main(String []args) throws JsonParseException, JsonMappingException, IOException{
		 BuyerResourceClient src=new BuyerResourceClient();
		System.out.println(src.getBuyer(2)); 
	}

	public List<Buyer> getBuyers(){
		Client client = ClientBuilder.newClient();

		WebTarget baseURL = client.target("http://localhost:5000/api/Buyer");
		List<Buyer> buyers = baseURL.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Buyer>>() {});
		client.close();
		return buyers;
		
	}
	public Buyer getBuyer(int id) throws JsonParseException, JsonMappingException, IOException{
		Client client = ClientBuilder.newClient();
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapper.setVisibilityChecker(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
		
		WebTarget baseUrl = client.target("http://localhost:5000/api/Buyer");
		WebTarget getBuyerURL=baseUrl.path(""+id);
		//Response response = getBuyerURL.request(MediaType.APPLICATION_JSON).get();
		//Buyer buyer=response.readEntity(Buyer.class);
		Buyer sh =mapper.readValue(getBuyerURL.request(MediaType.APPLICATION_JSON).get(String.class), Buyer.class);
		//response.close();
		client.close();
		return sh;
		
	}
	
	public int deleteBuyer(int id){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("http://localhost:5000/api/Buyer");
		WebTarget deleteBuyerURL=baseUrl.path(""+id);
		Response response=deleteBuyerURL.request().delete();
		return response.getStatus();
	}
	
	public int addBuyer(Buyer buyer){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("http://localhost:5000/api/Buyer");
		Response response=baseUrl.request().post(Entity.entity(buyer, MediaType.APPLICATION_JSON));
		
		return response.getStatus();
	}
	
	public int updateBuyer(Buyer buyer){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("http://localhost:5000/api/Buyer");
		WebTarget updateBuyerURL=baseUrl.path(""+buyer.getUserId());
		Response response=updateBuyerURL.request().put(Entity.entity(buyer, MediaType.APPLICATION_JSON));
		
		return response.getStatus();
	}


}
