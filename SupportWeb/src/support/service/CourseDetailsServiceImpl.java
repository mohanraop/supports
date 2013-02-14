package support.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import support.dao.CourseDetailsDao;
import support.domain.entity.ContactDetail;
import support.domain.entity.CourseDetails;

@Service("courseDetailsService")
@Transactional
public class CourseDetailsServiceImpl implements CourseDetailsService {
	@Resource(name = "courseDetailsDao")
	private CourseDetailsDao courseDetailsDao;

	@Override
	public ContactDetail findByNumber(String acctId) {
		return courseDetailsDao.findById(acctId);
	}

	@Override
	public void create(CourseDetails courseDetails) {
		courseDetailsDao.save(courseDetails);
	}

	@Override
	public List<CourseDetails> findAll() {
		return courseDetailsDao.findAll();
	}
}
