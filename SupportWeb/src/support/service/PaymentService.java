package support.service;

import support.domain.entity.PaymentDetails;


public interface PaymentService {
	
	PaymentDetails findByNumber(String paymentNumber);

	void savePayment(PaymentDetails paymentDetails);
}
