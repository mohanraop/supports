package support.web.jsf.mbean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.model.SelectItem;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import support.domain.entity.AssignDetails;
import support.domain.entity.ContactDetail;
import support.service.AssignService;
import support.service.ContactService;

@Component("memberAssignBean")
@Scope("request")
public class MemberAssignBean extends AbstractManagedBean  {
	private static final long serialVersionUID = -5650490585039961293L;
	
	private String status;

	private String supportType;
	
	private Date startDate;
	
	private Date endDate;
	
	private Integer trainerId;
	
	private Integer traineeId;
	
	private boolean readOnly=false;
	
	@Resource(name="contactService")
	private ContactService contactService;

	@Resource(name="assignService")
	private AssignService assignService;

	public Collection<SelectItem> getTrainers(){
		Collection<SelectItem> selectItems = new ArrayList<SelectItem>();
		List<ContactDetail> contactDetails = contactService.findTrainers();
		for(ContactDetail detail :contactDetails){
			selectItems.add(new SelectItem(detail.getId(),detail.getName()));
		}
		return selectItems;
	}
	public Collection<SelectItem> getTrainees(){
		Collection<SelectItem> selectItems = new ArrayList<SelectItem>();
		List<ContactDetail> contactDetails = contactService.findTrainees();
		for(ContactDetail detail :contactDetails){
			selectItems.add(new SelectItem(detail.getId(),detail.getName()));
		}
		return selectItems;
	}
	
	
	public void saveAssign() {
		AssignDetails assignDetails = new AssignDetails();
		ContactDetail trainee =  new ContactDetail();
		ContactDetail trainer =  new ContactDetail();
		if(getTraineeId()>0){
			trainee.setId(getTraineeId().toString());
			assignDetails.setTrainee(trainee);
		}
		if(getTrainerId()>0){
			trainer.setId(getTrainerId().toString());
			assignDetails.setTrainer(trainer);
		}
		if(getStartDate()!=null)
			assignDetails.setStartDate(getStartDate());
		if(getEndDate()!=null)
			assignDetails.setEndDate(getEndDate());
		if(getSupportType()!=null&&getSupportType().trim().length()>0)
			assignDetails.setSupportType(getSupportType());
		if(getStatus()!=null && getStatus().trim().length()>0)
			assignDetails.setStatus(getStatus());
		assignDetails.setCreateDateTime(new Date());
		assignService.create(assignDetails);
        addInfoMessage("Assignment  was successfully created.");
		readOnly=true;
	}
	
	public List<AssignDetails> getAssignDetails(){
		return assignService.findAll();		
	}
	

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * @return the supportType
	 */
	public String getSupportType() {
		return supportType;
	}

	/**
	 * @param supportType the supportType to set
	 */
	public void setSupportType(String supportType) {
		this.supportType = supportType;
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
	 * @return the trainerId
	 */
	public Integer getTrainerId() {
		return trainerId;
	}

	/**
	 * @param trainerId the trainerId to set
	 */
	public void setTrainerId(Integer trainerId) {
		this.trainerId = trainerId;
	}

	/**
	 * @return the traineeId
	 */
	public Integer getTraineeId() {
		return traineeId;
	}

	/**
	 * @param traineeId the traineeId to set
	 */
	public void setTraineeId(Integer traineeId) {
		this.traineeId = traineeId;
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


}
