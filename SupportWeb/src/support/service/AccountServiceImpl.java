package support.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import support.dao.AccountDao;
import support.domain.entity.AccountDetails;
import support.domain.entity.ContactDetail;


@Service("AccountService")
@Transactional
public class AccountServiceImpl implements AccountService {
  @Resource(name="AccountDao")
  private AccountDao accountDao;

  @Override
  public ContactDetail findByNumber(String acctId) {
    return accountDao.findById(acctId);
  }

  @Override
  public void create(AccountDetails accountDetails) {
	  accountDao.save(accountDetails);
  }
}
