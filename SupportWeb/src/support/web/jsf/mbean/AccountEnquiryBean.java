package support.web.jsf.mbean;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import support.dao.AccountDao;
import support.domain.entity.AccountDetails;
import support.service.FacilityService;


@Component("accountEnqBean")
@Scope("request")
public class AccountEnquiryBean implements Serializable {
  private static final long serialVersionUID = -5650490585039961293L;
  private Collection<AccountDetails> accountDetails;
  
  @Autowired
  private AccountDao AccountDao;
  
  @Resource(name = "facilityService")
  private FacilityService facilityService;

  public Collection<AccountDetails> getAccountDetails() {
    if(accountDetails == null) {
    	accountDetails = AccountDao.findAll();
    }
    return accountDetails;
  }

  
  
  public List<String> completeFacility(String query) {
    if (query.length() > 0 && query.length() < 5) {
      return facilityService.findFacilityCodesStartWith(query);
    }
    return null;
  }

}
