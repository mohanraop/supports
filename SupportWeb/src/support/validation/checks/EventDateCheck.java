package support.validation.checks;

import support.domain.enums.ErrorMessage;
import support.domain.enums.ValidationType;
import support.utils.TimestampUtil;
import support.validation.IncomingEvent;
import support.validation.ValidationEnvironment;

public class EventDateCheck extends AbstractValidationCheck {

  @Override
  public String getName() {
    return "Event Date Check";
  }

  @Override
  public boolean applyTo(IncomingEvent event, ValidationType validationType) {
    return true;
  }

  @Override
  public void validate(ValidationEnvironment validationEnvironment) {
    if (validationEnvironment.getEventDateTime().compareTo(TimestampUtil.now()) > 0) {
      validationEnvironment.raiseRejection(this, ErrorMessage.EVENT_DATE_GREATER_THAN_CURRENT_DATE);
    }
  }

}
