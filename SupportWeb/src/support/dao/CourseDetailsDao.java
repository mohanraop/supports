package support.dao;

import org.springframework.stereotype.Repository;

import support.domain.entity.CourseDetails;

@Repository("courseDetailsDao")
public class CourseDetailsDao extends AbstractBaseDao {

  @Override
  public Class<?> getDomainClass() {
    return CourseDetails.class;
  }

}
