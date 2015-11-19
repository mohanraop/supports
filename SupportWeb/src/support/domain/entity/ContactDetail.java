package support.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "SUP_CONTACT")
public class ContactDetail {
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "native")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "SUP_CONTACT_ID")
	private String id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "MOBILE_NO")
	private String mobileNum;
	
	@Column(name = "LOCATION")
	private String location;
	
	@Column(name = "GMAIL_ID")
	private String gmailID;
	
	@Column(name = "SKYPE_ID")
	private String skypeID;
	
	
	@Column(name = "TUPE_OF_MEM")
	private String memType;
	
	@Column(name = "JOIN_DT")
	private Date joiningDateTime;
	

	@Column(name = "CREATE_DT")
	private Date createDateTime;

	@Column(name = "UPDATE_DT")
	private Date updateDateTime;
	

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the mobileNum
	 */
	public String getMobileNum() {
		return mobileNum;
	}

	/**
	 * @param mobileNum the mobileNum to set
	 */
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the gmailID
	 */
	public String getGmailID() {
		return gmailID;
	}

	/**
	 * @param gmailID the gmailID to set
	 */
	public void setGmailID(String gmailID) {
		this.gmailID = gmailID;
	}

	/**
	 * @return the skypeID
	 */
	public String getSkypeID() {
		return skypeID;
	}

	/**
	 * @param skypeID the skypeID to set
	 */
	public void setSkypeID(String skypeID) {
		this.skypeID = skypeID;
	}

	/**
	 * @return the memType
	 */
	public String getMemType() {
		return memType;
	}

	/**
	 * @param memType the memType to set
	 */
	public void setMemType(String memType) {
		this.memType = memType;
	}

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
	 * @return the joiningDateTime
	 */
	public Date getJoiningDateTime() {
		return joiningDateTime;
	}

	/**
	 * @param joiningDateTime the joiningDateTime to set
	 */
	public void setJoiningDateTime(Date joiningDateTime) {
		this.joiningDateTime = joiningDateTime;
	}

}
