package support.validation.checks;

import support.domain.enums.ValidationType;
import support.validation.IncomingEvent;

public abstract class AbstractValidationCheck {

  public abstract String getName();
  
  public abstract boolean applyTo(IncomingEvent event, ValidationType validationType);
  
  //public abstract void validate(ValidationEnvironment validationEnvironment);
}
