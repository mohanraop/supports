package support.service;

import java.util.List;

import support.domain.entity.ContactDetail;
import support.domain.entity.CourseDetails;


public interface CourseDetailsService {

	ContactDetail findByNumber(String acctId);

	void create(CourseDetails courseDetails);
	
	List<CourseDetails> findAll();
}
