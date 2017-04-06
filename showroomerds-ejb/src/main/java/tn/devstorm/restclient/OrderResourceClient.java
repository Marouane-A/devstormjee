package tn.devstorm.restclient;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.typicode.jsonplaceholder.Order;

public class OrderResourceClient {
	public List<Order> getOrders(){
		Client client = ClientBuilder.newClient();

		WebTarget baseURL = client.target("http://localhost:5000/api/Order");
		List<Order> Orders = baseURL.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Order>>() {});
		client.close();
		return Orders;
		
	}
	public Order getOrder(int id){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("http://localhost:5000/api/Order");
		WebTarget getOrderURL=baseUrl.path(""+id);
		Response response = getOrderURL.request(MediaType.APPLICATION_JSON).get();
		Order Order=response.readEntity(Order.class);
		response.close();
		client.close();
		return Order;
		
	}
	
	public int deleteOrder(int id){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("http://localhost:5000/api/Order");
		WebTarget deleteOrderURL=baseUrl.path(""+id);
		Response response=deleteOrderURL.request().delete();
		return response.getStatus();
	}
	
	public int addOrder(Order Order){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("http://localhost:5000/api/Order");
		Response response=baseUrl.request().post(Entity.entity(Order, MediaType.APPLICATION_JSON));
		
		return response.getStatus();
	}
	
	public int updateOrder(Order Order){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("http://localhost:5000/api/Order");
		WebTarget updateOrderURL=baseUrl.path(""+Order.getOrderId());
		Response response=updateOrderURL.request().put(Entity.entity(Order, MediaType.APPLICATION_JSON));
		
		return response.getStatus();
	}

}
