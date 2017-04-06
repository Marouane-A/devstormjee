package tn.devstorm.restclient;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.typicode.jsonplaceholder.Interaction;

public class InteractionResourceClient {
	public List<Interaction> getInteractions(){
		Client client = ClientBuilder.newClient();

		WebTarget baseURL = client.target("http://localhost:5000/api/Interaction");
		List<Interaction> Interactions = baseURL.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Interaction>>() {});
		client.close();
		return Interactions;
		
	}
	public Interaction getInteraction(int id){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("http://localhost:5000/api/Interaction");
		WebTarget getInteractionURL=baseUrl.path(""+id);
		Response response = getInteractionURL.request(MediaType.APPLICATION_JSON).get();
		Interaction Interaction=response.readEntity(Interaction.class);
		response.close();
		client.close();
		return Interaction;
		
	}
	
	public int deleteInteraction(int id){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("http://localhost:5000/api/Interaction");
		WebTarget deleteInteractionURL=baseUrl.path(""+id);
		Response response=deleteInteractionURL.request().delete();
		return response.getStatus();
	}
	
	public int addInteraction(Interaction Interaction){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("http://localhost:5000/api/Interaction");
		Response response=baseUrl.request().post(Entity.entity(Interaction, MediaType.APPLICATION_JSON));
		
		return response.getStatus();
	}
	
	public int updateInteraction(Interaction Interaction){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("http://localhost:5000/api/Interaction");
		WebTarget updateInteractionURL=baseUrl.path(""+Interaction.getInteractionId());
		Response response=updateInteractionURL.request().put(Entity.entity(Interaction, MediaType.APPLICATION_JSON));
		
		return response.getStatus();
	}

}
