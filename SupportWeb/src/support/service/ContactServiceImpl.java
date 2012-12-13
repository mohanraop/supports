package support.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import support.dao.AssignDao;
import support.dao.ContactDao;
import support.domain.entity.AssignDetails;
import support.domain.entity.ContactDetail;


@Service("ContactService")
@Transactional
public class ContactServiceImpl implements ContactService {
	@Resource(name = "ContactDao")
	private ContactDao contactDao;
	
	@Resource(name = "AssignDao")
	private AssignDao assignDao; 

	@Override
	public char calculateCheckDigit(String containerNumber) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean validateCheckDigit(String containerNumber, char checkDigit) {
		return Character.isDigit(checkDigit)
				&& checkDigit == calculateCheckDigit(containerNumber);
	}

	@Override
	public ContactDetail findByNumber(String containerNumber) {
		return contactDao.findById(containerNumber);
	}

	@Override
	public void create(ContactDetail contactDetail) {
		contactDao.save(contactDetail);
	}

	@Override
	public List<ContactDetail> findTrainees() {
		Map<String, Object> propertyNameValue = new HashMap<String, Object>();
		propertyNameValue.put("memType", "Trainee");
		return contactDao.findBy(propertyNameValue);
	}

	@Override
	public List<ContactDetail> findTrainers() {
		Map<String, Object> propertyNameValue = new HashMap<String, Object>();
		propertyNameValue.put("memType", "Trainer");
		return contactDao.findBy(propertyNameValue);
	}
	
	@Override
	public void saveAssignment(AssignDetails assignDetails) {
		assignDao.save(assignDetails);
	}

	
}
