package support.web.jsf.mbean;

import java.util.EnumSet;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import support.domain.enums.Direction;
import support.domain.enums.DocumentType;
import support.domain.enums.EquipmentCondition;
import support.domain.enums.EventType;
import support.domain.enums.LoadEmptyIndicator;
import support.domain.enums.ValidationType;
import support.domain.enums.WeightUnit;
import support.service.EventValidationService;
import support.validation.IncomingMovementEvent;
import support.validation.ValidationError;
import support.validation.ValidationResult;


@Component("movementCaptureBean")
@Scope("request")
public class MovementCaptureBean extends AbstractManagedBean {

  private static final long serialVersionUID = 1906335266687624174L;

  @Resource(name = "eventValidationService")
  private EventValidationService eventValidationService;

  private IncomingMovementEvent incomingEvent;
  
  public IncomingMovementEvent getIncomingEvent() {
    if (incomingEvent == null) {
      incomingEvent = new IncomingMovementEvent();
    }
    return incomingEvent;
  }

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

  public void save() {
    buildIncomingEvent();
    ValidationResult result = eventValidationService.validateEvent(getIncomingEvent(), ValidationType.NEW);
    if(result.hasRejection()) {
      addWarnMessage("The movement has been rejected.  The reason as below:");
      for(ValidationError error : result.getValidationErrors()) {
        addWarnMessage(error.getErrorMessage().getDescription());
      }
    } else {
      addInfoMessage("Save Successful");
    }
  }

  private void buildIncomingEvent() {
  }

}
