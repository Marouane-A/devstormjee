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
import com.typicode.jsonplaceholder.Showroomer;

public class ShowroomerResourceClient {
	public static void main(String []args) throws JsonParseException, JsonMappingException, IOException{
		 ShowroomerResourceClient src=new ShowroomerResourceClient();
		System.out.println(src.getShowroomer(3)); 
	}

	public List<Showroomer> getShowroomers(){
		Client client = ClientBuilder.newClient();

		WebTarget baseURL = client.target("http://localhost:5000/api/Showroomer");
		List<Showroomer> showroomers = baseURL.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Showroomer>>() {});
		client.close();
		return showroomers;
		
	}
	public Showroomer getShowroomer(int id) throws JsonParseException, JsonMappingException, IOException{
		Client client = ClientBuilder.newClient();
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapper.setVisibilityChecker(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
		
		WebTarget baseUrl = client.target("http://localhost:5000/api/Showroomer");
		WebTarget getShowroomerURL=baseUrl.path(""+id);
		//Response response = getShowroomerURL.request(MediaType.APPLICATION_JSON).get();
		//Showroomer showroomer=response.readEntity(Showroomer.class);
		Showroomer sh =mapper.readValue(getShowroomerURL.request(MediaType.APPLICATION_JSON).get(String.class), Showroomer.class);
		//response.close();
		client.close();
		return sh;
		
	}
	
	public int deleteShowroomer(int id){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("http://localhost:5000/api/Showroomer");
		WebTarget deleteShowroomerURL=baseUrl.path(""+id);
		Response response=deleteShowroomerURL.request().delete();
		return response.getStatus();
	}
	
	public int addShowroomer(Showroomer showroomer){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("http://localhost:5000/api/Showroomer");
		Response response=baseUrl.request().post(Entity.entity(showroomer, MediaType.APPLICATION_JSON));
		
		return response.getStatus();
	}
	
	public int updateShowroomer(Showroomer showroomer){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("http://localhost:5000/api/Showroomer");
		WebTarget updateShowroomerURL=baseUrl.path(""+showroomer.getUserId());
		Response response=updateShowroomerURL.request().put(Entity.entity(showroomer, MediaType.APPLICATION_JSON));
		
		return response.getStatus();
	}

}
