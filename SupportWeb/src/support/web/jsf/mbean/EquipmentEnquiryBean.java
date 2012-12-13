package support.web.jsf.mbean;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import support.domain.bo.EquipmentMovementAssociated;
import support.domain.entity.EquipmentEvent;
import support.domain.entity.EquipmentLatestInfo;
import support.domain.entity.MovementEvent;
import support.service.EquipmentEventService;
import support.service.EquipmentLatestInfoService;
import support.service.MovementEventService;


@Component("equipmentEnquiryBean")
@Scope("request")
public class EquipmentEnquiryBean extends AbstractManagedBean {

  private static final long serialVersionUID = 2268013658546622642L;

  @Resource(name = "equipmentLatestInfoService")
  private EquipmentLatestInfoService equipmentLatestInfoService;

  @Resource(name = "movementEventService")
  private MovementEventService movementEventService;
  
  @Resource(name = "equipmentEventService")
  private EquipmentEventService equipmentEventService;

  private String containerNumber;

  private EquipmentLatestInfo equipmentLatestInfo = new EquipmentLatestInfo();

  private Set<EquipmentMovementAssociated> eventLogs = new TreeSet<EquipmentMovementAssociated>();

  public String getContainerNumber() {
    return containerNumber;
  }

  public void setContainerNumber(String containerNumber) {
    this.containerNumber = containerNumber;
  }

  public void search() {
    EquipmentLatestInfo equipmentLatestInfo = equipmentLatestInfoService.findByEquipmentNumber(containerNumber);
    if (equipmentLatestInfo == null) {
      addErrorMessage("Equipment not exists");
    } else {
      setEquipmentLatestInfo(equipmentLatestInfo);
      List<MovementEvent> movementEvents = movementEventService.findByContainerNumber(containerNumber);
      for(MovementEvent movementEvent : movementEvents) {
        eventLogs.add(new EquipmentMovementAssociated(movementEvent));
      }
      List<EquipmentEvent> equipmentEvents = equipmentEventService.findByEquipmentNumber(containerNumber);
      for(EquipmentEvent equipmentEvent : equipmentEvents) {
        eventLogs.add(new EquipmentMovementAssociated(equipmentEvent));
      }
    }
  }

  public List<EquipmentMovementAssociated> getTablelist() {
    return new ArrayList<EquipmentMovementAssociated>(eventLogs);
  }

  public EquipmentLatestInfo getEquipmentLatestInfo() {
    return equipmentLatestInfo;
  }

  public void setEquipmentLatestInfo(EquipmentLatestInfo equipmentLatestInfo) {
    this.equipmentLatestInfo = equipmentLatestInfo;
  }

}
