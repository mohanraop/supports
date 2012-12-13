package support.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import support.dao.EquipmentLatestInfoDao;
import support.domain.entity.EquipmentLatestInfo;


@Service("equipmentLatestInfoService")
public class EquipmentLatestInfoServiceImpl implements EquipmentLatestInfoService {

  @Resource(name = "equipmentLatestInfoDao")
  private EquipmentLatestInfoDao equipmentLatestInfoDao;

  @Override
  public EquipmentLatestInfo findByEquipmentNumber(String containerNumber) {
    return equipmentLatestInfoDao.findById(containerNumber);
  }

}
