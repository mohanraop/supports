package support.service;

import java.util.Date;
import java.util.List;

import support.domain.entity.EquipmentEvent;


public interface EquipmentEventService {
  EquipmentEvent findLastEventBeforeDate(String equipmentNumber, Date date);
  List<EquipmentEvent> findByEquipmentNumber(String equipmentNumber);
}
