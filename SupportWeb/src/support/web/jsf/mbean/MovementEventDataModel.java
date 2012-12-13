package support.web.jsf.mbean;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import support.domain.entity.MovementEvent;


public class MovementEventDataModel extends ListDataModel<MovementEvent> implements SelectableDataModel<MovementEvent> {

  public MovementEventDataModel() {
    super();
  }

  public MovementEventDataModel(List<MovementEvent> data) {
    super(data);
  }

  @SuppressWarnings("unchecked")
  @Override
  public MovementEvent getRowData(String eventTimestamp) {
    List<MovementEvent> movementEvents = (List<MovementEvent>)getWrappedData();
    for(MovementEvent movementEvent : movementEvents) {
      if(movementEvent.getEventTimestamp().equals(eventTimestamp)) {
        return movementEvent;
      }
    }
    return null;
  }

  @Override
  public Object getRowKey(MovementEvent movementEvent) {
    return movementEvent.getEventTimestamp();
  }

}
