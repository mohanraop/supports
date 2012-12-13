package support.validation.checks;

import support.validation.ValidationEnvironment;

public interface ICheck {
  String getName();
  void validate(ValidationEnvironment validationEnvironment);
}
