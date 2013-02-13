package support.service;

import java.util.List;

import support.domain.entity.ContactDetail;
import support.domain.entity.TransactionDetails;


public interface TransactionService {

	ContactDetail findByNumber(String acctId);

	void create(TransactionDetails transactionDetails);
	
	List<TransactionDetails> findAll();
}
