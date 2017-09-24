package decay.client.module.mods;

import decay.client.event.events.EventPlayerUpdate;
import decay.client.logger.DecayLogger;
import decay.client.module.Module;
import org.lwjgl.input.Keyboard;

import java.util.HashMap;

public class Flight extends Module {

    public Flight(boolean enabled) {
        super(
                "Flight",
                "Allows player to fly",
                Keyboard.KEY_CAPITAL,
                new HashMap<String, String>(),
                enabled
        );
    }

    private boolean oldFlying;
    private float oldFlySpeed;

    @Override
    public void onRegister() {
        this.getArgs().put("speed", "1");
        super.onRegister();
    }

    @Override
    public void onEnable() {
        // subscribe to event
        EventPlayerUpdate.INSTANCE.subscribe(this);

        // save pre-flight variables
        oldFlying = mc.player.capabilities.isFlying;
        oldFlySpeed = mc.player.capabilities.getFlySpeed();

        // set new variables
        float newSpeed = 0.1f;
        try{
            newSpeed = Float.parseFloat(this.getArgs().get("speed")) / 10;
        }catch (Exception e){
            DecayLogger.INSTANCE.print("Invalid entry for speed in " + this.getName() + ": " + this.getArgs().get("speed")
            + "\nDefaulting to 1");
        }
        mc.player.capabilities.setFlySpeed(newSpeed);
        mc.player.capabilities.isFlying = true;
    }

    @Override
    public void onDisable() {
        // unsubscribe from event
        EventPlayerUpdate.INSTANCE.unsubscribe(this);

        // reset to pre-flight variables
        mc.player.capabilities.isFlying = oldFlying;
        mc.player.capabilities.setFlySpeed(oldFlySpeed);
    }

    @Override
    public void EventPlayerUpdate() {

        float newSpeed = 0.1f;
        try{
            newSpeed = Float.parseFloat(this.getArgs().get("speed")) / 10;
        }catch (Exception e){
            DecayLogger.INSTANCE.print("Invalid entry for speed in " + this.getName() + ": " + this.getArgs().get("speed")
                    + "\nDefaulting to 1");
        }

        // force new variables
        mc.player.capabilities.setFlySpeed(newSpeed);
        mc.player.capabilities.isFlying = true;
    }
}
