package tn.devstorm.restclient;

import java.util.List;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.typicode.jsonplaceholder.User;

public class UserResourceClient {

	public static void main (String [] args){
		UserResourceClient urc =new UserResourceClient();
		System.out.println(urc.getUser(1));
	}
	public List<User> getUsers(){
		Client client = ClientBuilder.newClient();

		WebTarget baseURL = client.target("http://localhost:5000/api/User/getall");
		List<User> Users = baseURL.request(MediaType.APPLICATION_JSON).get(new GenericType<List<User>>() {});
		client.close();
		return Users;
		
	}
	public String getUser(int id){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("http://localhost:5000/api/User");
		//WebTarget getUserURL=baseUrl.path(""+id);
		//String response = getUserURL.request(MediaType.APPLICATION_JSON).get(String.class);
		String response = baseUrl.request(MediaType.APPLICATION_JSON).header("id", id).get(String.class);
		/*if (response.contains("\"deliveryAddress\":\"")){
			return "showroomer";
		}
		else{
			if(response.contains("\"description\":\"")){
				return "buyer" ;
			}
			else{
				User User=response.readEntity(User.class);
				return "user";
			}
			
		}*/
		//User User=response.readEntity(User.class);
		
		//return User;
		//response.close();
		//client.close();
		return response;
		
	}
	
	public int deleteUser(int id){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("http://localhost:5000/api/User");
		WebTarget deleteUserURL=baseUrl.path(""+id);
		Response response=deleteUserURL.request().delete();
		return response.getStatus();
	}
	
	public int addUser(User User){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("http://localhost:5000/api/User");
		Response response=baseUrl.request().post(Entity.entity(User, MediaType.APPLICATION_JSON));
		
		return response.getStatus();
	}
	
	public int updateUser(User User){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("http://localhost:5000/api/User");
		WebTarget updateUserURL=baseUrl.path(""+User.getUserId());
		Response response=updateUserURL.request().put(Entity.entity(User, MediaType.APPLICATION_JSON));
		
		return response.getStatus();
	}



}
