package tn.devstorm.restclient;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.typicode.jsonplaceholder.Purchase;

public class PurchaseResourceClient {
	public List<Purchase> getPurchases(){
		Client client = ClientBuilder.newClient();

		WebTarget baseURL = client.target("http://localhost:5000/api/Purchase");
		List<Purchase> Purchases = baseURL.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Purchase>>() {});
		client.close();
		return Purchases;
		
	}
	public Purchase getPurchase(int id){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("http://localhost:5000/api/Purchase");
		WebTarget getPurchaseURL=baseUrl.path(""+id);
		Response response = getPurchaseURL.request(MediaType.APPLICATION_JSON).get();
		Purchase Purchase=response.readEntity(Purchase.class);
		response.close();
		client.close();
		return Purchase;
		
	}
	
	public int deletePurchase(int id){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("http://localhost:5000/api/Purchase");
		WebTarget deletePurchaseURL=baseUrl.path(""+id);
		Response response=deletePurchaseURL.request().delete();
		return response.getStatus();
	}
	
	public int addPurchase(Purchase Purchase){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("http://localhost:5000/api/Purchase");
		Response response=baseUrl.request().post(Entity.entity(Purchase, MediaType.APPLICATION_JSON));
		
		return response.getStatus();
	}
	
	public int updatePurchase(Purchase Purchase){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("http://localhost:5000/api/Purchase");
		WebTarget updatePurchaseURL=baseUrl.path(""+Purchase.getPurchaseId());
		Response response=updatePurchaseURL.request().put(Entity.entity(Purchase, MediaType.APPLICATION_JSON));
		
		return response.getStatus();
	}

}



