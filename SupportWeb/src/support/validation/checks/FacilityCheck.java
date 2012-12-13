package support.validation.checks;

import support.domain.entity.SupplyHierarchy;
import support.domain.enums.ErrorMessage;
import support.domain.enums.ValidationType;
import support.validation.IncomingEvent;
import support.validation.ValidationEnvironment;

public class FacilityCheck extends AbstractValidationCheck {

  @Override
  public String getName() {
    return "Facility Check";
  }

  @Override
  public boolean applyTo(IncomingEvent event, ValidationType validationType) {
    return true;
  }

  @Override
  public void validate(ValidationEnvironment validationEnvironment) {
    SupplyHierarchy supplyHierarchy = validationEnvironment.getSupplyHierarchy();
    if(supplyHierarchy == null) {
      validationEnvironment.raiseRejection(this, ErrorMessage.FACILITY_NOT_EXISTS);
    }
  }

}
