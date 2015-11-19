package support.dao;

import org.springframework.stereotype.Repository;

import support.domain.entity.TransactionDetails;

@Repository("transactiontDao")
public class TransactionDao extends AbstractBaseDao {

  @Override
  public Class<?> getDomainClass() {
    return TransactionDetails.class;
  }

}
