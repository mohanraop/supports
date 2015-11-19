package support.service;

import java.util.List;

import support.domain.entity.AccountDetails;
import support.domain.entity.ContactDetail;


public interface AccountService {

	ContactDetail findByNumber(String acctId);

	void create(AccountDetails accountDetails);
	
	List<AccountDetails> findAll();
}
