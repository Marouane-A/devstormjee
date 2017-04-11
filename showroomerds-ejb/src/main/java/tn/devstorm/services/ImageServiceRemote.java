package tn.devstorm.services;

import java.io.IOException;

import javax.ejb.Local;
//import javax.ejb.Remote;

import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxException;
@Local
public interface ImageServiceRemote {
	public String authorization() throws IOException, DbxException;
	void uploadToDropbox(String fileName, DbxClient dbxClient, int id) throws DbxException, IOException;
	}
