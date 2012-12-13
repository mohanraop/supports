package support.service;

import support.domain.entity.Container;

public interface ContainerService {
  char calculateCheckDigit(String containerNumber);
  boolean validateCheckDigit(String containerNumber, char checkDigit);
  Container findByNumber(String containerNumber);
  void create(Container container);
}
