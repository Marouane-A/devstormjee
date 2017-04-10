package tn.devstorm.services;

import javax.ejb.Stateless;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.GraphResponse;
import com.restfb.types.Post;
import com.typicode.jsonplaceholder.Product;

import tn.devstorm.restclient.ProductResourceClient;
@Stateless
public class FbService implements FbServiceLocal{
	
	 public static final String MY_ACCESS_TOKEN = "EAAC16ZCCEoEUBAN0nSMO26hmeriTiHK3PiyFZBssrlQC1OEmPm0cmMOZAoXhuHZAtcTTCu4e7YpmO7k8PcZAqSX5c7uypz4VKqFOYxCwZBVaS9QteqDkByc9E8YMaPopdHdaOXAJy6P8wl5pTSX92SgN9tppbH8hlTZBTdQCV6C2dMiWtl4sEsi";
	
	 public static final String MY_APP_ID = "200024957165637";
	 public static final String MY_APP_SECRET = "d5b9b30ca886b9d666b0568a989875d8";
	 public static final String My_App_Token = "200025413832258|zXI4jdg5giuZmTA1abt8q-NA_SU";
	 public static final String Prodfb= "491718177618651_493264130797389";
	 
	public FbService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String fbpostproduct(int prodId) {
		ProductResourceClient prc =new ProductResourceClient();
		Product prod = prc.getProduct(prodId);
		FacebookClient fc = 
			       new DefaultFacebookClient(MY_ACCESS_TOKEN, Version.VERSION_2_8);
		String x= fc.publish("me/feed", GraphResponse.class,
		     Parameter.with("message","Check this New Product <3 <3  😍 👍👍👍 "+ prod.getName()+"\n||Brand :"+prod.getBrand()+"\n||Price :"+prod.getPrice()+"\n Stay tuned there a bunch of new Stuff Coming Soon 🔥🔥🔥") ).getId();
		prod.setFacebookId(x);
		
		prc.updateProduct(prod);
		return x;
	}

	@Override
	public void fbCommentProd(int prodId, String text) {
		ProductResourceClient prc =new ProductResourceClient();
		
		Product prod = prc.getProduct(prodId);
		String fbid=prod.getFacebookId();
		if(fbid==null){
		System.out.println("Product not shared on FACEBOOK");	
		}
		else{
			FacebookClient fc = 
				       new DefaultFacebookClient(MY_APP_ID,MY_APP_SECRET, Version.VERSION_2_8);
			fc.publish(fbid+"/comments", GraphResponse.class, Parameter.with("message", text));
		}
		
		
		
	}
	@Override
	public long getCountComments(int prodId){
		ProductResourceClient prc =new ProductResourceClient();
		Product prod = prc.getProduct(prodId);
		String fbid=prod.getFacebookId();
		if(fbid==null){
			System.out.println("Product not shared on FACEBOOK");
			return 0;
			}
			else{
		 FacebookClient fc = 
			       new DefaultFacebookClient(MY_ACCESS_TOKEN, Version.VERSION_2_8);
		return fc.fetchObject(fbid,Post.class,Parameter.with("fields", "comments.summary(true)")).getCommentsCount();
			}
	 }
	@Override
	 public long getCountLikes(int prodId){
			ProductResourceClient prc =new ProductResourceClient();
			Product prod = prc.getProduct(prodId);
			String fbid=prod.getFacebookId();
			if(fbid==null){
				System.out.println("Product not shared on FACEBOOK");
				return 0;
				}
				else{
		 FacebookClient fc = 
			       new DefaultFacebookClient(MY_ACCESS_TOKEN, Version.VERSION_2_8);
		return fc.fetchObject(fbid,Post.class,Parameter.with("fields", "likes.summary(true)") ).getLikesCount();
				}
	 }
	@Override
	 public long getCountShares(int prodId){
			ProductResourceClient prc =new ProductResourceClient();
			Product prod = prc.getProduct(prodId);
			String fbid=prod.getFacebookId();
			if(fbid==null){
				System.out.println("Product not shared on FACEBOOK");
				return 0;
				}
				else{
		 FacebookClient fc = 
			       new DefaultFacebookClient(MY_ACCESS_TOKEN, Version.VERSION_2_8);
		return fc.fetchObject(fbid,Post.class,Parameter.with("fields", "shares") ).getSharesCount();
				}
	 }

}
