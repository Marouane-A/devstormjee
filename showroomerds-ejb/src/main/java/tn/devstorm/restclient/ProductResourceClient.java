package tn.devstorm.restclient;

import java.util.List;

import javax.naming.spi.DirStateFactory.Result;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.stream.events.Comment;

import com.typicode.jsonplaceholder.Product;
import com.typicode.jsonplaceholder.User;

public class ProductResourceClient {

	public static void main(String[] args) {
		System.out.println("Hello");
		ProductResourceClient prc = new ProductResourceClient();
		UserResourceClient urc =new UserResourceClient();
		
		List<User> lu= urc.getUsers(); 
		List<Product>lp= prc.getProducts();
		System.out.println(lu);	
		System.out.println(prc.getProduct(2));
	}
	public List<Product> getProducts(){
		Client client = ClientBuilder.newClient();

		WebTarget baseURL = client.target("http://localhost:5000/api/Product");
		List<Product> products = baseURL.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Product>>() {});
		client.close();
		return products;
		
	}
	public Product getProduct(int id){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("http://localhost:5000/api/Product");
		WebTarget getProductURL=baseUrl.path(""+id);
		Response response = getProductURL.request(MediaType.APPLICATION_JSON).get();
		Product product=response.readEntity(Product.class);
		response.close();
		client.close();
		return product;
		
	}
	
	public int deleteProduct(int id){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("http://localhost:5000/api/Product");
		WebTarget deleteProductURL=baseUrl.path(""+id);
		Response response=deleteProductURL.request().delete();
		return response.getStatus();
	}
	
	public int addProduct(Product product){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("http://localhost:5000/api/Product");
		Response response=baseUrl.request().post(Entity.entity(product, MediaType.APPLICATION_JSON));
		
		return response.getStatus();
	}
	
	public int updateProduct(Product product){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("http://localhost:5000/api/Product");
		WebTarget updateProductURL=baseUrl.path(""+product.getProductId());
		Response response=updateProductURL.request().put(Entity.entity(product, MediaType.APPLICATION_JSON));
		
		return response.getStatus();
	}




}
