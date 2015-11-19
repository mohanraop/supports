package support.web.jsf.mbean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.model.SelectItem;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import support.domain.entity.AccountDetails;
import support.domain.entity.ContactDetail;
import support.domain.entity.PaymentDetails;
import support.domain.entity.TransactionDetails;
import support.service.AccountService;
import support.service.ContactService;
import support.service.PaymentService;
import support.service.TransactionService;

@Component("memberPaymentBean")
@Scope("request")
public class MemberPaymentBean extends AbstractManagedBean  {
	private static final long serialVersionUID = -5650490585039961293L;
	
	private Date paymentDate;
	
	private Date startDate;
	
	private Date endDate;
	
	private Integer memberId;
	
	private Integer accountId;
	
	private Double ammount;
	
	private String paymentType;
	
	private String currency;
	
	private Double currencyRate;
	
	
	
	private boolean readOnly=false;
	
	


	@Resource(name="contactService")
	private ContactService contactService;
	
	@Resource(name="accountService")
	private AccountService accountService;
	
	@Resource(name="paymentService")
	private PaymentService paymentService; 
	
	@Resource(name = "transactionService")
	private TransactionService transactionService;

	

	public Collection<SelectItem> getMembers(){
		Collection<SelectItem> selectItems = new ArrayList<SelectItem>();
		List<ContactDetail> contactDetails = contactService.findAll();
		for(ContactDetail detail :contactDetails){
			selectItems.add(new SelectItem(detail.getId(),detail.getName()));
		}
		return selectItems;
	}
	public Collection<SelectItem> getAccounts(){
		Collection<SelectItem> selectItems = new ArrayList<SelectItem>();
		List<AccountDetails> accountDetails = accountService.findAll();
		for(AccountDetails detail :accountDetails){
			selectItems.add(new SelectItem(detail.getId(),detail.getActNum()+"-"+detail.getActHldrName()));
		}
		return selectItems;
	}
	
	
	public void savePayment() {
		PaymentDetails paymentDetails = new PaymentDetails();
		if(getMemberId()>0)
			paymentDetails.setMemberId(getMemberId());
		if(getAccountId()>0)
			paymentDetails.setAccountId(getAccountId());
		if(getAmmount()>0)
			paymentDetails.setAmmount(getAmmount());
		if(getPaymentDate()!=null)
			paymentDetails.setPaymentDate(getPaymentDate());
		if(getStartDate()!=null)
			paymentDetails.setStartDate(getStartDate());
		if(getEndDate()!=null)
			paymentDetails.setEndDate(getEndDate());
		if(getPaymentType()!=null&&getPaymentType().trim().length()>0)
			paymentDetails.setPaymentType(getPaymentType());
		if(getCurrency()!=null && getCurrency().trim().length()>0)
			paymentDetails.setCurrency(getCurrency());
		if(getCurrencyRate()>0)
			paymentDetails.setCurrencyRate(getCurrencyRate());
		paymentDetails.setCreateDateTime(new Date());
		paymentService.savePayment(paymentDetails);
		TransactionDetails transactionDetails = new TransactionDetails(); 
		AccountDetails accountDetails = new AccountDetails();
		accountDetails.setId(""+getAccountId());
		transactionDetails.setAccountDetails(accountDetails);
		transactionDetails.setCreateDateTime(new Date());
		transactionDetails.setOperation(getPaymentType());
		transactionDetails.setAmount(getAmmount().toString());
		transactionService.create(transactionDetails);
        addInfoMessage("Payment completed.");
		readOnly=true;
	}

	

	/**
	 * @return the paymentDate
	 */
	public Date getPaymentDate() {
		return paymentDate;
	}
	/**
	 * @param paymentDate the paymentDate to set
	 */
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the memberId
	 */
	public Integer getMemberId() {
		return memberId;
	}
	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	/**
	 * @return the accountId
	 */
	public Integer getAccountId() {
		return accountId;
	}
	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	/**
	 * @return the ammount
	 */
	public Double getAmmount() {
		return ammount;
	}
	/**
	 * @param ammount the ammount to set
	 */
	public void setAmmount(Double ammount) {
		this.ammount = ammount;
	}
	/**
	 * @return the paymentType
	 */
	public String getPaymentType() {
		return paymentType;
	}
	/**
	 * @param paymentType the paymentType to set
	 */
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	/**
	 * @return the cuurrencyRate
	 */
	public Double getCurrencyRate() {
		return currencyRate;
	}
	/**
	 * @param cuurrencyRate the cuurrencyRate to set
	 */
	public void setCurrencyRate(Double currencyRate) {
		this.currencyRate = currencyRate;
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

}
