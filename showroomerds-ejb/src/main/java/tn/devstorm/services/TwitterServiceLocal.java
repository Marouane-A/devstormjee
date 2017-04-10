package tn.devstorm.services;

import javax.ejb.Local;

import twitter4j.TwitterException;

@Local
public interface TwitterServiceLocal {
	public String twitte(int prodId);

}
