package support.service;

import support.domain.entity.EquipmentLatestInfo;

public interface EquipmentLatestInfoService {
  EquipmentLatestInfo findByEquipmentNumber(String containerNumber);
}
