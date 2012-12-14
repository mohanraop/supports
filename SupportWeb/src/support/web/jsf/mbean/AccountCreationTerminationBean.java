package support.web.jsf.mbean;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import support.domain.entity.AccountDetails;
import support.service.AccountService;

@Component("accountCTBean")
@Scope("view")
public class AccountCreationTerminationBean extends AbstractManagedBean {
	private static final long serialVersionUID = 964800661749286255L;

	private String id;

	private String actHldrName;
	private String actHldrAddr;
	private String actBranch;
	private String actNum;
	private String ifscCode;
	private String bankAddr;
	private Date createDateTime;
	private Date updateDateTime;
	private boolean readOnly = false;

	@Resource(name = "accountService")
	private AccountService accountService;

	public void saveCreation() {
		AccountDetails accountDetails = new AccountDetails();
		setValues(accountDetails);
		accountService.create(accountDetails);
		addInfoMessage("Member : " + getActNum() + " was successfully created.");
		readOnly = true;
	}
	
	private void setValues(AccountDetails accountDetails){
		if(getActHldrName()!=null&&getActHldrName().trim().length()>0)
		accountDetails.setActHldrName(getActHldrName());
		
		if(getActHldrAddr()!=null&&getActHldrAddr().trim().length()>0)
			accountDetails.setActHldrAddr(getActHldrAddr());
		
		if(getActBranch()!=null&&getActBranch().trim().length()>0)
			accountDetails.setActBranch(getActBranch());
		
		if(getActNum()!=null&&getActNum().trim().length()>0)
			accountDetails.setActNum(getActNum());
		
		if(getIfscCode()!=null&&getIfscCode().trim().length()>0)
			accountDetails.setIfscCode(getIfscCode());
		
		if(getBankAddr()!=null&&getBankAddr().trim().length()>0)
			accountDetails.setBankAddr(getBankAddr());

		accountDetails.setCreateDateTime(new Date());
		
		
	}

	public void saveTermination() {

	}

	/**
	 * @return the readOnly
	 */
	public boolean isReadOnly() {
		return readOnly;
	}

	/**
	 * @param readOnly
	 *            the readOnly to set
	 */
	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the actHldrName
	 */
	public String getActHldrName() {
		return actHldrName;
	}

	/**
	 * @param actHldrName the actHldrName to set
	 */
	public void setActHldrName(String actHldrName) {
		this.actHldrName = actHldrName;
	}

	/**
	 * @return the actHldrAddr
	 */
	public String getActHldrAddr() {
		return actHldrAddr;
	}

	/**
	 * @param actHldrAddr
	 *            the actHldrAddr to set
	 */
	public void setActHldrAddr(String actHldrAddr) {
		this.actHldrAddr = actHldrAddr;
	}

	/**
	 * @return the actBranch
	 */
	public String getActBranch() {
		return actBranch;
	}

	/**
	 * @param actBranch
	 *            the actBranch to set
	 */
	public void setActBranch(String actBranch) {
		this.actBranch = actBranch;
	}

	/**
	 * @return the actNum
	 */
	public String getActNum() {
		return actNum;
	}

	/**
	 * @param actNum
	 *            the actNum to set
	 */
	public void setActNum(String actNum) {
		this.actNum = actNum;
	}

	/**
	 * @return the ifscCode
	 */
	public String getIfscCode() {
		return ifscCode;
	}

	/**
	 * @param ifscCode
	 *            the ifscCode to set
	 */
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	/**
	 * @return the bankAddr
	 */
	public String getBankAddr() {
		return bankAddr;
	}

	/**
	 * @param bankAddr
	 *            the bankAddr to set
	 */
	public void setBankAddr(String bankAddr) {
		this.bankAddr = bankAddr;
	}

	/**
	 * @return the createDateTime
	 */
	public Date getCreateDateTime() {
		return createDateTime;
	}

	/**
	 * @param createDateTime
	 *            the createDateTime to set
	 */
	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	/**
	 * @return the updateDateTime
	 */
	public Date getUpdateDateTime() {
		return updateDateTime;
	}

	/**
	 * @param updateDateTime
	 *            the updateDateTime to set
	 */
	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
