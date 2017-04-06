package tn.devstorm.restclient;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.typicode.jsonplaceholder.Comment;
import com.typicode.jsonplaceholder.Product;
import com.typicode.jsonplaceholder.User;

public class CommentResourceClient {
	public static void main(String[] args) {
		System.out.println("Hello");
		
		CommentResourceClient crc =new CommentResourceClient();
		 
		System.out.println(crc.getCommentt(1));
		
	}
	public List<Comment> getComments(){
		Client client = ClientBuilder.newClient();

		WebTarget baseURL = client.target("http://localhost:5000/api/Comment");
		List<Comment> Comments = baseURL.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Comment>>() {});
		client.close();
		return Comments;
		
	}
	public String getComment(int id){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("http://localhost:5000/api/Comment");
		WebTarget getCommentURL=baseUrl.path(""+id);
		String response = getCommentURL.request(MediaType.APPLICATION_JSON).get(String.class);
		//Comment Comment=response.readEntity(Comment.class);
		//response.close();
		client.close();
		return response;
		
	}
	public Comment getCommentt(int id){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("http://localhost:5000/api/Comment");
		WebTarget getCommentURL=baseUrl.path(""+id);
		Response response = getCommentURL.request(MediaType.APPLICATION_JSON).get();
		Comment Comment=response.readEntity(Comment.class);
		response.close();
		client.close();
		return Comment;
		
	}
	
	
	public int deleteComment(int id){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("http://localhost:5000/api/Comment");
		WebTarget deleteCommentURL=baseUrl.path(""+id);
		Response response=deleteCommentURL.request().delete();
		return response.getStatus();
	}
	
	public int addComment(Comment Comment){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("http://localhost:5000/api/Comment");
		Response response=baseUrl.request().post(Entity.entity(Comment, MediaType.APPLICATION_JSON));
		
		return response.getStatus();
	}
	
	public int updateComment(Comment Comment){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("http://localhost:5000/api/Comment");
		WebTarget updateCommentURL=baseUrl.path(""+Comment.getCommentId());
		Response response=updateCommentURL.request().put(Entity.entity(Comment, MediaType.APPLICATION_JSON));
		
		return response.getStatus();
	}


}
