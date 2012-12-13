package support.service;

import java.util.Collection;

import support.domain.entity.ContainerIsoType;


public interface ContainerIsoTypeService {
  Collection<String> getAllIsoCodes();
  Collection<String> getAllGroupCodes();
  String getGroupByIso(String isoCode);
  Collection<String> getIsoByGroup(String groupCode);
  Collection<ContainerIsoType> getAll();
}
