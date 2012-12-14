package support.dao;

import org.springframework.stereotype.Repository;

import support.domain.entity.PaymentDetails;


@Repository("paymentDao")
public class PaymentDao extends AbstractBaseDao {

  @Override
  public Class<?> getDomainClass() {
    return PaymentDetails.class;
  }

}
