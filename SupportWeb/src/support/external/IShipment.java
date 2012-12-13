package support.external;

import support.domain.entity.MovementEvent;
import support.domain.enums.DocumentType;

public interface IShipment {
  ShipmentRoute getShipment(String containerNumber, String documentReference, DocumentType documentType);
  void addMovement(MovementEvent movemenetEvent);
}
