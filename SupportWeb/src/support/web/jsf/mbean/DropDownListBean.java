package support.web.jsf.mbean;

import java.util.EnumSet;

import org.springframework.stereotype.Component;

import support.domain.enums.Direction;
import support.domain.enums.DocumentType;
import support.domain.enums.EquipmentCondition;
import support.domain.enums.EventType;
import support.domain.enums.LoadEmptyIndicator;
import support.domain.enums.WeightUnit;


@Component
public class DropDownListBean {

  public EnumSet<WeightUnit> getWeightUnits() {
    return EnumSet.allOf(WeightUnit.class);
  }

  public EnumSet<EventType> getEventTypes() {
    return EnumSet.of(EventType.ISSUE, EventType.RECEIVE, EventType.DISCHARGE, EventType.LOADING, EventType.DEVANNING,
        EventType.VANNING, EventType.REPACK, EventType.UNLINK, EventType.LINK);
  }

  public EnumSet<LoadEmptyIndicator> getLoadEmptyIndicators() {
    return EnumSet.allOf(LoadEmptyIndicator.class);
  }

  public EnumSet<EquipmentCondition> getEquipmentConditions() {
    return EnumSet.allOf(EquipmentCondition.class);
  }

  public EnumSet<DocumentType> getDocumentTypes() {
    return EnumSet.of(DocumentType.BM, DocumentType.BN, DocumentType.EP);
  }

  public EnumSet<Direction> getDirections() {
    return EnumSet.allOf(Direction.class);
  }

}
