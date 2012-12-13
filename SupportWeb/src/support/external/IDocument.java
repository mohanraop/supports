package support.external;

import support.domain.entity.MovementEvent;

public interface IDocument {
  TrackingGroup getTrackingGroup(String trackingGroupCode);
  void addMovement(MovementEvent movemenetEvent);
}
