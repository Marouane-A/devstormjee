package tn.devstorm.services;

import javax.ejb.Remote;



@Remote
public interface TestRemote {
	public String showUser(int id);
	

}
