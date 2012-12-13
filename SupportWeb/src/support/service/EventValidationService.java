package support.service;

import support.domain.enums.ValidationType;
import support.validation.IncomingEvent;
import support.validation.ValidationResult;

public interface EventValidationService {
  ValidationResult validateEvent(IncomingEvent event, ValidationType validationType);
}
