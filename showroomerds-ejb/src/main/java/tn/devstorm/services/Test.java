package tn.devstorm.services;

import javax.ejb.Stateless;

import tn.devstorm.restclient.UserResourceClient;
@Stateless
public class Test implements TestRemote {
	UserResourceClient urc =new UserResourceClient();
	
	@Override
	public String showUser(int id) {
		return urc.getUser(id).toString();		
	}

}
