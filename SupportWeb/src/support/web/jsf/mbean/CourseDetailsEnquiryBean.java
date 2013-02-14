package support.web.jsf.mbean;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import support.dao.CourseDetailsDao;
import support.domain.entity.CourseDetails;
import support.service.FacilityService;


@Component("courseDetailsEnqBean")
@Scope("request")
public class CourseDetailsEnquiryBean implements Serializable {
  private static final long serialVersionUID = -5650490585039961293L;
  private Collection<CourseDetails> courseDetails;
  
  @Autowired
  private CourseDetailsDao CourseDetailsDao;
  
  @Resource(name = "facilityService")
  private FacilityService facilityService;

  public Collection<CourseDetails> getCourseDetails() {
    if(courseDetails == null) {
    	courseDetails = CourseDetailsDao.findAll();
    }
    return courseDetails;
  }

  
  
  public List<String> completeFacility(String query) {
    if (query.length() > 0 && query.length() < 5) {
      return facilityService.findFacilityCodesStartWith(query);
    }
    return null;
  }

}
