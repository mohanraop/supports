package support.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import support.dao.TransactionDao;
import support.domain.entity.ContactDetail;
import support.domain.entity.TransactionDetails;

@Service("transactionService")
@Transactional
public class TransactionServiceImpl implements TransactionService {
	@Resource(name = "transactiontDao")
	private TransactionDao transactionDao;
	@Override
	public ContactDetail findByNumber(String acctId) {
		return transactionDao.findById(acctId);
	}

	@Override
	public void create(TransactionDetails transactionDetails) {
		transactionDao.save(transactionDetails);
	}

	@Override
	public List<TransactionDetails> findAll() {
		return transactionDao.findAll();
	}
}
