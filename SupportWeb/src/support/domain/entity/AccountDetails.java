package support.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "SUP_ACCOUNT")
public class AccountDetails {
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "native")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "SUP_ACCOUNT_id")
	private String id;
	@Column(name = "ACT_HLDR_NAME")
	private String actHldrName;

	@Column(name = "ACT_HLDR_ADDR")
	private String actHldrAddr;
	@Column(name = "ACT_BRANCH")
	private String actBranch;
	@Column(name = "ACT_NUM")
	private String actNum;
	@Column(name = "IFSC_CODE")
	private String ifscCode;
	@Column(name = "BANK_ADDR")
	private String bankAddr;

	@Column(name = "CREATE_DT")
	private Date createDateTime;

	@Column(name = "UPDATE_DT")
	private Date updateDateTime;

	/**
	 * @return the createDateTime
	 */
	public Date getCreateDateTime() {
		return createDateTime;
	}

	/**
	 * @param createDateTime the createDateTime to set
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
	 * @param updateDateTime the updateDateTime to set
	 */
	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
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

}
