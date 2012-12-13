package support.dao;

import org.springframework.stereotype.Repository;

import support.domain.entity.Container;


@Repository("containerDao")
public class ContainerDao extends AbstractBaseDao {

  @Override
  public Class<?> getDomainClass() {
    return Container.class;
  }

}
