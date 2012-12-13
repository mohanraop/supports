package support.dao;

import org.springframework.stereotype.Repository;

import support.domain.entity.ContactDetail;

@Repository("ContactDao")
public class ContactDao extends AbstractBaseDao {

  @Override
  public Class<?> getDomainClass() {
    return ContactDetail.class;
  }

}
