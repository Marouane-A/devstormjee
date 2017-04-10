package tn.devstorm.services;

import javax.ejb.Local;

@Local
public interface FbServiceLocal {
	
	public String fbpostproduct(int prodId);
	public void fbCommentProd(int prodid,String text);
	 public long getCountComments(int fbid);
	 public long getCountLikes(int fbid);
	 public long getCountShares(int fbid);
}
