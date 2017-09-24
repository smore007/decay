package decay.client.event.events;

import decay.client.event.Event;
import decay.client.event.IEventHandler;

import java.util.ArrayList;

public class EventPlayerLivingUpdate extends Event {

    public static final EventPlayerLivingUpdate INSTANCE = new EventPlayerLivingUpdate();

    public EventPlayerLivingUpdate() {
        super(
                "EventPlayerLivingUpdate",
                new ArrayList<>()
        );
    }

    public void fire(){
        for(IEventHandler handler : this.getSubscribers())
            handler.EventPlayerUpdate();
    }
}
