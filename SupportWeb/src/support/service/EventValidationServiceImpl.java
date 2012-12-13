package support.service;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import support.domain.enums.ValidationType;
import support.validation.EquipmentEventValidation;
import support.validation.IncomingEvent;
import support.validation.MovementEventValidation;
import support.validation.ValidationResult;


@Service("eventValidationService")
@Transactional
@Scope("prototype")
public class EventValidationServiceImpl implements EventValidationService {
  @Resource(name = "movementEventValidation")
  private MovementEventValidation movementEventValidation;
  @Resource(name = "equipmentEventValidation")
  private EquipmentEventValidation equipmentEventValidation;

  @Override
  public ValidationResult validateEvent(IncomingEvent event, ValidationType validationType) {
    switch (validationType) {
    case NEW:
    case REVALIDATE:
      return movementEventValidation.validate(event, validationType, true);
    case EDIT:
      return movementEventValidation.validate(event, validationType, false);
    case CREATION:
    case TERMINATION:
      return equipmentEventValidation.validate(event, validationType, true);
    default:
      return null;
    }
  }
}
