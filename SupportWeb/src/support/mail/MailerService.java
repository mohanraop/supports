package support.mail;

import support.web.jsf.mbean.MailBean;

public interface MailerService {
	
	public void sendMail(MailBean mailBean);

}
