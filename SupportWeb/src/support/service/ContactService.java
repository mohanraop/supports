package support.service;

import java.util.List;

import support.domain.entity.ContactDetail;


public interface ContactService {
	char calculateCheckDigit(String contactNumber);

	boolean validateCheckDigit(String contactNumber, char checkDigit);

	ContactDetail findByNumber(String contactNumber);

	void create(ContactDetail contactDetail);
	
	List<ContactDetail> findTrainees();
	
	List<ContactDetail> findTrainers();
	
	List<ContactDetail> findAll();

}
