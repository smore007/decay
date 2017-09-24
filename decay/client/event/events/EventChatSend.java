package decay.client.event.events;

import decay.client.command.CommandManager;
import decay.client.event.Event;
import decay.client.event.IEventHandler;

import java.util.ArrayList;

public class EventChatSend extends Event {

    public static final EventChatSend INSTANCE = new EventChatSend();

    public EventChatSend() {
        super(
                "EventChatSend",
                new ArrayList<>()
        );
    }

    /**
     * Returns whether or not it would like to hook the message
     * @param message
     * @return
     */
    public boolean fire(String message){
        boolean sendable;
        for(IEventHandler handler : this.getSubscribers()){
            if(handler.HandleMessage(message))
                return false;
        }
        return true;
    }
}
