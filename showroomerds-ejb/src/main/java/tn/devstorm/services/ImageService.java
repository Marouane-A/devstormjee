package tn.devstorm.services;

import com.dropbox.core.*;
import com.typicode.jsonplaceholder.Image;
import com.typicode.jsonplaceholder.Product;

import tn.devstorm.restclient.ImageResourceClient;
import tn.devstorm.restclient.ProductResourceClient;

import java.awt.Desktop;
import java.io.*;
import java.util.Locale;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
@Stateless
public class ImageService implements ImageServiceRemote{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	ImageService im = new ImageService();
		try {
			System.out.println(im.authorization());
			
		//	im.uploadToDropbox("src/happy.png", client , 4);
		} catch (DbxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Override
	public String authorization() throws IOException, DbxException {
		final String APP_KEY = "sc5w60s1za6gbae";
		final String APP_SECRET = "ja8gapnigwcm2zc";

		DbxAppInfo appInfo = new DbxAppInfo(APP_KEY, APP_SECRET);

		DbxRequestConfig config = new DbxRequestConfig("JavaTutorial/1.0", Locale.getDefault().toString());
		DbxWebAuthNoRedirect webAuth = new DbxWebAuthNoRedirect(config, appInfo);

		// Have the user sign in and authorize your app.
		//String authorizeUrl = webAuth.start();
		//System.out.println("1. Go to: " + authorizeUrl);
	//	System.out.println("2. Click \"Allow\" (you might have to log in first)");
	//	System.out.println("3. Copy the authorization code.");
	//	Desktop.getDesktop().browse(java.net.URI.create(authorizeUrl));
	//	String code = new BufferedReader(new InputStreamReader(System.in)).readLine().trim();
	//	DbxAuthFinish authFinish = webAuth.finish(code);
		String accessToken = "losZQH9q8AAAAAAAAAAATjGN83_ygy-Jw5oOkSBdXctSYsoE3QN6-g9b0Cn1c6lo";
     	DbxClient client = new DbxClient(config, accessToken);
		System.out.println("Linked account: " + client.getAccountInfo().displayName);

		return client.getAccountInfo().displayName;
	}
	@Override
	public void uploadToDropbox(String fileName, DbxClient dbxClient, int id) throws DbxException, IOException {
		ProductResourceClient prc = new ProductResourceClient();
		ImageResourceClient irc = new ImageResourceClient();
		File inputFile = new File(fileName);
		FileInputStream fis = new FileInputStream(inputFile);
		try {
			DbxEntry.File uploadedFile = dbxClient.uploadFile("/" + fileName, DbxWriteMode.add(), inputFile.length(),
					fis);
			String sharedUrl = dbxClient.createShareableUrl("/" + fileName);
			Product p = prc.getProduct(id);
			Image im = new Image() ;
			//im.setImageId(2);
			im.setName(fileName);
			im.setUrl(sharedUrl);
			im.setProductId(id);
			im.setProduct(p);
			irc.addImage(im);
			System.out.println("Uploaded: " + uploadedFile.toString() + " URL " + sharedUrl);
		} finally {
			fis.close();
		}
	}
}
