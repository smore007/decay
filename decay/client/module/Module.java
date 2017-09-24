package decay.client.module;

import decay.client.event.IEventHandler;
import decay.client.event.events.EventKeySend;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;

import java.util.HashMap;

public abstract class Module implements IEventHandler {

    protected Minecraft mc = Minecraft.getMinecraft();
    protected NetHandlerPlayClient net = Minecraft.getMinecraft().getConnection();

    public String name, description;
    public int toggleKey;
    public HashMap<String, String> args;
    public boolean enabled;

    public Module(String name, String description, int toggleKey, HashMap<String, String> args, boolean enabled) {
        this.name = name;
        this.description = description;
        this.toggleKey = toggleKey;
        this.args = args;
        this.enabled = enabled;
    }

    /**
     * Getters and setters + toggle
     */

    public void toggleMod(){
        this.enabled = !this.enabled;
        this.onToggle();
        if(this.enabled)
            this.onEnable();
        else
            this.onDisable();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getToggleKey() {
        return toggleKey;
    }

    public HashMap<String, String> getArgs() {
        return args;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setToggleKey(int toggleKey) {
        this.toggleKey = toggleKey;
    }

    /**
     * Module-specific events
     */

    public void onRegister(){
        EventKeySend.INSTANCE.subscribe(this);
    }

    public void onUnregister(){
        EventKeySend.INSTANCE.unsubscribe(this);
    }

    public void onToggle(){

    }

    public void onEnable(){

    }

    public void onDisable(){

    }

    /**
     * Events
     */

    @Override
    public void EventPlayerUpdate() {

    }

    @Override
    public void EventPlayerLivingUpdate() {

    }

    @Override
    public void EventTick() {

    }

    @Override
    public void EventLivingUpdate() {

    }

    @Override
    public void EventKeySend(int keyCode) {
        if(keyCode == this.toggleKey)
            this.toggleMod();
    }

    @Override
    public boolean HandleMessage(String message) {
        return false;
    }
}
