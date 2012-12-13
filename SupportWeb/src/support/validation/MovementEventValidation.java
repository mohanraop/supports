package support.validation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import support.dao.MovementEventDao;
import support.domain.entity.MovementEvent;
import support.validation.checks.AbstractValidationCheck;
import support.validation.checks.ContainerCheck;
import support.validation.checks.EventDateCheck;
import support.validation.checks.FacilityCheck;


@Service
@Scope("prototype")
public class MovementEventValidation extends EventValidationTemplate {

  @Autowired
  private MovementEventDao movementEventDao;

  @Override
  protected void initializeRules(List<AbstractValidationCheck> rules) {
    rules.add(new ContainerCheck());
    rules.add(new EventDateCheck());
    rules.add(new FacilityCheck());
  }

  @Override
  protected void addToEventLog() {
    MovementEvent event = validationEnvironment.createMovementEventLog();
    movementEventDao.save(event);
  }

  @Override
  protected void updateOrCreateEquipment() {
    // do nothing
  }
}
