package support.dao;

import org.springframework.stereotype.Repository;

import support.domain.entity.ContactDetail;

@Repository("assignDao")
public class AssignDao extends AbstractBaseDao {

  @Override
  public Class<?> getDomainClass() {
    return ContactDetail.class;
  }

}
