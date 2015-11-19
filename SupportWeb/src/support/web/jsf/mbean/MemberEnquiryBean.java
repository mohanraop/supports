package support.web.jsf.mbean;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import support.domain.entity.ContactDetail;
import support.service.ContactService;


@Component("memberEnqBean")
@Scope("request")
public class MemberEnquiryBean {


	@Resource(name="contactService")
	private ContactService contactService;
	
	public Collection<ContactDetail> getContactDetails(){
		List<ContactDetail> contactDetails = contactService.findAll();
		return contactDetails;
	}
}
