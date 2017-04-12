package tn.devstorm.services;
import javax.ejb.Stateless;

import com.typicode.jsonplaceholder.*;

@Stateless
public class MailTest implements MailLocal {
	public static void main(String[] args) {
		MailTest m = new MailTest();
		m.mailsend("test");
	}
	
	@Override
	public String mailsend (String subject) {
		Mail.setUSER_NAME((String) /*AuthenticationController.getAuth().getMail()*/"majdeddine.letaief" );
        Mail.setPASSWORD(/*(String) PwTF.getText()*/"Ice&Fire16");
        Mail.setRECIPIENT(/*(String) CommentsAndReportsController.selected.getSenderMail()*/"majdeddine.letaief@esprit.tn");
        
        Mail.setSsubject(subject);
        String Texte="Bonjour Monsieur !";
        Mail.setBbody(Texte);
        String[] to = {Mail.getRECIPIENT()};
        Mail.sendFromGMaill(Mail.getUSER_NAME(), Mail.getPASSWORD(), to, Mail.getSsubject(), Mail.getBbody());
        
        return "success!";
	}
}

