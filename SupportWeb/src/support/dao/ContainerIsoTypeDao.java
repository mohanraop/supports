package support.dao;

import org.springframework.stereotype.Repository;

import support.domain.entity.ContainerIsoType;

@Repository("containerIsoTypeDao")
public class ContainerIsoTypeDao extends AbstractBaseDao {

  @Override
  public Class<?> getDomainClass() {
    return ContainerIsoType.class;
  }

}
