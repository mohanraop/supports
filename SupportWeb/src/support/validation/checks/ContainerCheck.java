package support.validation.checks;

import support.domain.entity.Container;
import support.domain.enums.ErrorMessage;
import support.domain.enums.ValidationType;
import support.validation.IncomingEvent;
import support.validation.ValidationEnvironment;

public class ContainerCheck extends AbstractValidationCheck {
  public final static String NAME = "Container Check";

  @Override
  public String getName() {
    return NAME;
  }

  @Override
  public boolean applyTo(IncomingEvent event, ValidationType validationType) {
    return true;
  }

  @Override
  public void validate(ValidationEnvironment validationEnvironment) {
    Container container = validationEnvironment.getContainerInfo();
    if(container == null) {
      validationEnvironment.raiseRejection(this, ErrorMessage.CONTAINER_NOT_EXISTS);
    } else if(container.isActive()) {
      validationEnvironment.raiseRejection(this, ErrorMessage.CONTAINER_INACTIVE);
    }
  }

}
