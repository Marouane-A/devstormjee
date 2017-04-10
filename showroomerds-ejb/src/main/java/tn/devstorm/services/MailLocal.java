package tn.devstorm.services;

import javax.ejb.Local;

@Local
public interface MailLocal  {
	public String mailsend (String subject);
}
