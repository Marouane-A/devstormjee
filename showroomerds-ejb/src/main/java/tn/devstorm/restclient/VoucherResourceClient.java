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
import com.typicode.jsonplaceholder.Order;
import com.typicode.jsonplaceholder.Voucher;

public class VoucherResourceClient {
	
	public static void main(String []args) throws JsonParseException, JsonMappingException, IOException{
		 VoucherResourceClient src=new VoucherResourceClient();
		System.out.println(src.getVoucher(3)); 
	}

	public List<Voucher> getVouchers(){
		Client client = ClientBuilder.newClient();

		WebTarget baseURL = client.target("http://localhost:5000/api/Voucher");
		List<Voucher> vouchers = baseURL.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Voucher>>() {});
		client.close();
		return vouchers;
		
	}
	public Voucher getVoucher(int id) throws JsonParseException, JsonMappingException, IOException{
		Client client = ClientBuilder.newClient();
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapper.setVisibilityChecker(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
		
		WebTarget baseUrl = client.target("http://localhost:5000/api/Voucher");
		WebTarget getVoucherURL=baseUrl.path(""+id);
		//Response response = getVoucherURL.request(MediaType.APPLICATION_JSON).get();
		//Voucher voucher=response.readEntity(Voucher.class);
		Voucher sh =mapper.readValue(getVoucherURL.request(MediaType.APPLICATION_JSON).get(String.class), Voucher.class);
		//response.close();
		client.close();
		return sh;
		
	}
	
	public int deleteVoucher(int id){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("http://localhost:5000/api/Voucher");
		WebTarget deleteVoucherURL=baseUrl.path(""+id);
		Response response=deleteVoucherURL.request().delete();
		return response.getStatus();
	}
	
	public int addVoucher(Voucher voucher){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("http://localhost:5000/api/Voucher");
		Response response=baseUrl.request().post(Entity.entity(voucher, MediaType.APPLICATION_JSON));
		
		return response.getStatus();
	}
	
	public int updateVoucher(Voucher voucher){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("http://localhost:5000/api/Voucher");
		WebTarget updateVoucherURL=baseUrl.path(""+voucher.getReference());
		Response response=updateVoucherURL.request().put(Entity.entity(voucher, MediaType.APPLICATION_JSON));
		
		return response.getStatus();
	}

}


