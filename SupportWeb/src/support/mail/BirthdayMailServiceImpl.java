package support.mail;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import support.web.jsf.mbean.MailBean;


@Service("birthdayMailService")
@Transactional

public class BirthdayMailServiceImpl implements BirthdayMailService{
	@Resource(name = "mailSender")
	MailSender mailSender;
	public void sendBirthdayMail(MimeMessage mimeMessage,MailBean mailBean) throws Exception {
		 
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
 
        mimeMessageHelper.setTo(mailBean.getToAddress());     
        mimeMessageHelper.setSubject("Birthday Wishes");
 
        StringBuilder text = new StringBuilder();
        text.append("<html>");
        text.append("<body>");
        text.append("<h3>Birthday Wish</h3>");
        text.append("<p>Wishing you a very happy birthday " +mailBean.getUserName() + ".</p>");
        text.append("<p><img src=\"cid:greetingImage\"/></p>");
        text.append("</body>");
        text.append("</html>");
 
        // Sets the text
        mimeMessageHelper.setText(text.toString(), true);
 
        // Inline content
        FileSystemResource inlineContent = new FileSystemResource("/greetingImage.jpg");            
        mimeMessageHelper.addInline("greetingImage", inlineContent);
 
        //Attachment
        FileSystemResource greetingImage = new FileSystemResource("/greeting.jpg");
        mimeMessageHelper.addAttachment("Greeting", greetingImage);
      /*  
        System.out.println("Wishing birthday for " + iterator.next());
        
        MimeMessage mimeMessage = sender.createMimeMessage();

        User user = iterator.next();

        sender.send(birthdayMessagePreparator);*/
    }
}
