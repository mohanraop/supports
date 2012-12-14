package support.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import support.dao.PaymentDao;
import support.domain.entity.PaymentDetails;


@Service("paymentService")
@Transactional
public class PaymentServiceImpl implements PaymentService {
	
	@Resource(name = "paymentDao")
	private PaymentDao paymentDao;

	@Override
	public PaymentDetails findByNumber(String paymentNumber) {
		return paymentDao.findById(paymentNumber);
	}

	@Override
	public void savePayment(PaymentDetails paymentDetails) {
		paymentDao.save(paymentDetails)		;
	}
	
	

	
}
