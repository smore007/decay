package decay.client.event.events;

import decay.client.event.Event;
import decay.client.event.IEventHandler;

import java.util.ArrayList;

public class EventLivingUpdate extends Event {

    public static final EventLivingUpdate INSTANCE = new EventLivingUpdate();

    public EventLivingUpdate() {
        super(
                "EventLivingUpdate",
                new ArrayList<>()
        );
    }

    public void fire(){
        for(IEventHandler handler : this.getSubscribers())
            handler.EventPlayerUpdate();
    }
}
