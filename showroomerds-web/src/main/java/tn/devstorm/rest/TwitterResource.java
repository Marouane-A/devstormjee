package tn.devstorm.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.typicode.jsonplaceholder.Product;

import tn.devstorm.restclient.ProductResourceClient;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;


@Path("/twit")
@RequestScoped
public class TwitterResource {
	
	
	@GET
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public Response twitPost(@HeaderParam("id") int prodId) {
		ProductResourceClient prc =new ProductResourceClient();
		Product prod = prc.getProduct(prodId);
		
		
			
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true)
			  .setOAuthConsumerKey("Fxhnc3bNRmHi5xlsPV8cEB3lz")
			  .setOAuthConsumerSecret("DSW1uZ4HLGhvlSYBMuu2XyidaXfmyGljvvfIdQbIgRdmgzzvLk")
			  .setOAuthAccessToken("851156034928463873-uk1XtMSkiC8k8k4UUgeZFCSTPRoyXYn")
			  .setOAuthAccessTokenSecret("4PRdc1kC6Z9QTI5OtMAbzIHE29tr9bqqnqqTIGSP9EpSu");
			//AccessToken token = new AccessToken("851156034928463873-uk1XtMSkiC8k8k4UUgeZFCSTPRoyXYn", "4PRdc1kC6Z9QTI5OtMAbzIHE29tr9bqqnqqTIGSP9EpSu", 851156034928463873l);
			TwitterFactory tf = (TwitterFactory) new TwitterFactory(cb.build());
			Twitter twitter = tf.getInstance();
		   
				try {
					twitter4j.Status	status = twitter.updateStatus("Check this New Product "+ prod.getName()+"||Brand: "+prod.getBrand()+"||Price: "+prod.getPrice());
				
				//status = (Status) twitter.directMessages();
				System.out.println("Successfully updated the status to [" + status.getText() + "].");
				
				} catch (TwitterException e) {
					
					e.printStackTrace();
				}
		    
			
		return Response.status(Status.OK).build();
		
	}
}
