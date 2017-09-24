package decay.client.event.events;

import decay.client.event.Event;
import decay.client.event.IEventHandler;

import java.util.ArrayList;

public class EventKeySend extends Event {

    public static final EventKeySend INSTANCE = new EventKeySend();

    public EventKeySend() {
        super(
                "EventKeySend",
                new ArrayList<>()
        );
    }

    public void fire(int keyCode){
        for(IEventHandler handler : this.getSubscribers())
            handler.EventKeySend(keyCode);
    }
}
