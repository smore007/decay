package decay.client.event;

import decay.client.logger.DecayLogger;

import java.util.ArrayList;
import java.util.HashMap;

public class Event {

    public String name;
    public ArrayList<IEventHandler> subscribers;

    public Event(String name, ArrayList<IEventHandler> subscribers) {
        this.name = name;
        this.subscribers = subscribers;
    }

    public void subscribe(IEventHandler handler){
        this.subscribers.add(handler);
        DecayLogger.INSTANCE.print(handler.getClass().toString() + " just subbed to " + this.name);
    }

    public void unsubscribe(IEventHandler handler){
        this.subscribers.remove(handler);
        DecayLogger.INSTANCE.print(handler.getClass().toString() + " just unsubbed from " + this.name);
    }

    public String getName() {
        return name;
    }

    public ArrayList<IEventHandler> getSubscribers() {
        return subscribers;
    }
}
