package support.web.jsf.mbean;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import support.domain.entity.AccountDetails;
import support.domain.entity.CourseDetails;
import support.service.AccountService;
import support.service.CourseDetailsService;
import support.service.TransactionService;

@Component("courseDetailsCTBean")
@Scope("view")
public class CourseDetailsCreationTerminationBean extends AbstractManagedBean {
	private static final long serialVersionUID = 964800661749286255L;

	private String id;

	private String courseNam;
	private String courseDtls;
	private String courseDur;
	private String courseAmt;
	private Date createDateTime;
	private Date updateDateTime;
	private boolean readOnly = false;


	@Resource(name = "courseDetailsService")
	private CourseDetailsService courseDetailsService;

	public void saveCreation() {
		CourseDetails courseDetails = new CourseDetails();
		setValues(courseDetails);
		courseDetailsService.create(courseDetails);
		addInfoMessage("Course : " + getCourseNam()
				+ " was successfully created.");
		readOnly = true;
	}

	private void setValues(CourseDetails courseDetails) {
		if (getCourseNam() != null && getCourseNam().trim().length() > 0)
			courseDetails.setCourseName(getCourseNam());

		if (getCourseDtls() != null && getCourseDtls().trim().length() > 0)
			courseDetails.setCourseDetails(getCourseDtls());

		if (getCourseDur() != null && getCourseDur().trim().length() > 0)
			courseDetails.setCourseDuration(getCourseDur());

		if (getCourseAmt() != null && getCourseAmt().trim().length() > 0)
			courseDetails.setCourseAmount(getCourseAmt());

		courseDetails.setCreateDateTime(new Date());

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

	public String getCourseNam() {
		return courseNam;
	}

	public void setCourseNam(String courseNam) {
		this.courseNam = courseNam;
	}

	public String getCourseDtls() {
		return courseDtls;
	}

	public void setCourseDtls(String courseDtls) {
		this.courseDtls = courseDtls;
	}

	public String getCourseDur() {
		return courseDur;
	}

	public void setCourseDur(String courseDur) {
		this.courseDur = courseDur;
	}

	public String getCourseAmt() {
		return courseAmt;
	}

	public void setCourseAmt(String courseAmt) {
		this.courseAmt = courseAmt;
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
