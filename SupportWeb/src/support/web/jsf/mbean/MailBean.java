package support.web.jsf.mbean;

public class MailBean {
	private String toAddress; 
	
	private String userName;
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the toAddress
	 */
	public String getToAddress() {
		return toAddress;
	}
	/**
	 * @param toAddress the toAddress to set
	 */
	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * @return the messageTxt
	 */
	public String getMessageTxt() {
		return messageTxt;
	}
	/**
	 * @param messageTxt the messageTxt to set
	 */
	public void setMessageTxt(String messageTxt) {
		this.messageTxt = messageTxt;
	}
	private String subject;
	private String messageTxt;
	
}

