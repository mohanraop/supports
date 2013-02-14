package support.mail;

import javax.annotation.Resource;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import support.web.jsf.mbean.MailBean;

@Service("mailerService")
@Transactional
public class MailerServiceImpl implements MailerService {
	@Resource(name = "mailSender")
	MailSender mailSender;

	public void sendMail(MailBean mailBean) {

		SimpleMailMessage message = new SimpleMailMessage();

		message.setTo(mailBean.getToAddress());
		message.setSubject(mailBean.getSubject());
		message.setText(mailBean.getMessageTxt());

		mailSender.send(message);
	}

}
