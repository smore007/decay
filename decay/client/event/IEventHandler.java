package decay.client.event;

public interface IEventHandler {

    // player specific
    void EventPlayerUpdate();
    void EventPlayerLivingUpdate();

    // all entities
    void EventTick();
    void EventLivingUpdate();

    // other
    void EventKeySend(int keyCode);
    boolean HandleMessage(String message);
}
