package support.dao;

import org.springframework.stereotype.Repository;

import support.domain.entity.AccountDetails;

@Repository("accountDao")
public class AccountDao extends AbstractBaseDao {

  @Override
  public Class<?> getDomainClass() {
    return AccountDetails.class;
  }

}
