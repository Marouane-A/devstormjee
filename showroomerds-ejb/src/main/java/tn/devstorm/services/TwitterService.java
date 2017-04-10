package tn.devstorm.services;

import javax.ejb.Stateless;

import com.typicode.jsonplaceholder.Product;

import tn.devstorm.restclient.ProductResourceClient;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Stateless
public class TwitterService implements TwitterServiceLocal {

	@Override
	public String twitte(int prodId) {
		ProductResourceClient prc =new ProductResourceClient();
		Product prod = prc.getProduct(prodId);
		String fbid=prod.getFacebookId();
		if(fbid==null){
			System.out.println("Product not shared on FACEBOOK");
			return null;
			}
			else{
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true)
			  .setOAuthConsumerKey("Fxhnc3bNRmHi5xlsPV8cEB3lz")
			  .setOAuthConsumerSecret("DSW1uZ4HLGhvlSYBMuu2XyidaXfmyGljvvfIdQbIgRdmgzzvLk")
			  .setOAuthAccessToken("851156034928463873-uk1XtMSkiC8k8k4UUgeZFCSTPRoyXYn")
			  .setOAuthAccessTokenSecret("4PRdc1kC6Z9QTI5OtMAbzIHE29tr9bqqnqqTIGSP9EpSu");
			//AccessToken token = new AccessToken("851156034928463873-uk1XtMSkiC8k8k4UUgeZFCSTPRoyXYn", "4PRdc1kC6Z9QTI5OtMAbzIHE29tr9bqqnqqTIGSP9EpSu", 851156034928463873l);
			TwitterFactory tf = (TwitterFactory) new TwitterFactory(cb.build());
			Twitter twitter = tf.getInstance();
		    Status status;
			
				try {
					status = twitter.updateStatus("Check this New Product "+ prod.getName()+"||Brand: "+prod.getBrand()+"||Price: "+prod.getPrice());
				
				//status = (Status) twitter.directMessages();
				System.out.println("Successfully updated the status to [" + status.getText() + "].");
				return status.getText();
				} catch (TwitterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    return null;
			}
	
		}
	

}
