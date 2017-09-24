package decay.client.event.events;

import decay.client.event.Event;
import decay.client.event.IEventHandler;

import java.util.ArrayList;

public class EventPlayerUpdate extends Event {

    public static final EventPlayerUpdate INSTANCE = new EventPlayerUpdate();

    public EventPlayerUpdate() {
        super(
                "EventPlayerUpdate",
                new ArrayList<>()
        );
    }

    public void fire(){
        for(IEventHandler handler : this.getSubscribers())
            handler.EventPlayerUpdate();
    }
}
