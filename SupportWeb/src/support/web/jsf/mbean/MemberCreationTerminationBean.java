package support.web.jsf.mbean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.annotation.Resource;
import javax.faces.model.SelectItem;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import support.domain.entity.ContactDetail;
import support.service.ContactService;


@Component("memberCTBean")
@Scope("view")
public class MemberCreationTerminationBean extends AbstractManagedBean {
	private static final long serialVersionUID = 964800661749286255L;

	private String selectedMemberType;
	private String memName;
	private String gmailId;
	private String skypeId;
	private String mobileNum;
	private String address;
	private String reference;
	private Date joiningDate;
	private boolean readOnly=false;


	@Resource(name = "ContactService")
	private ContactService contactService;

	public void saveCreation() {
		ContactDetail contactDetail = new ContactDetail();
		contactDetail.setMemType(getSelectedMemberType());
		contactDetail.setName(getMemName());
		contactDetail.setJoiningDateTime(getJoiningDate());
		contactService.create(contactDetail);
        addInfoMessage("Member : " +getMemName() + " was successfully created.");
		readOnly=true;
	}

	public void saveTermination() {
		
	}
	
	


	public Collection<SelectItem> getGroupCodes() {
		Collection<SelectItem> selectItems = new ArrayList<SelectItem>();

		return selectItems;
	}

	public String getSelectedMemberType() {
		return selectedMemberType;
	}

	public void setSelectedMemberType(String selectedMemberType) {
		this.selectedMemberType = selectedMemberType;
	}

	/**
	 * @return the memName
	 */
	public String getMemName() {
		return memName;
	}

	/**
	 * @param memName
	 *            the memName to set
	 */
	public void setMemName(String memName) {
		this.memName = memName;
	}

	/**
	 * @return the gmailId
	 */
	public String getGmailId() {
		return gmailId;
	}

	/**
	 * @param gmailId
	 *            the gmailId to set
	 */
	public void setGmailId(String gmailId) {
		this.gmailId = gmailId;
	}

	/**
	 * @return the skypeId
	 */
	public String getSkypeId() {
		return skypeId;
	}

	/**
	 * @param skypeId
	 *            the skypeId to set
	 */
	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}

	/**
	 * @return the mobileNum
	 */
	public String getMobileNum() {
		return mobileNum;
	}

	/**
	 * @param mobileNum
	 *            the mobileNum to set
	 */
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}
	

	/**
	 * @return the readOnly
	 */
	public boolean isReadOnly() {
		return readOnly;
	}

	/**
	 * @param readOnly the readOnly to set
	 */
	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * @param reference
	 *            the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}

	/**
	 * @return the joiningDate
	 */
	public Date getJoiningDate() {
		return joiningDate;
	}

	/**
	 * @param joiningDate
	 *            the joiningDate to set
	 */
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

}
