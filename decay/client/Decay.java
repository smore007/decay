package decay.client;

import decay.client.command.CommandManager;
import decay.client.event.events.EventKeySend;
import decay.client.logger.DecayLogger;
import decay.client.module.ModuleManager;

public class Decay {

    public static final Decay INSTANCE = new Decay();

    public String name = "Decay";
    public String version = "beta0.1";
    public String author = "smore";

    /**
     * Called before Minecraft launched
     */
    public void preInit(){

    }

    /**
     * Called while Minecraft launches
     */
    public void init(){
        DecayLogger.INSTANCE.init();
        ModuleManager.INSTANCE.init();
        CommandManager.INSTANCE.init();
    }

    /**
     * Called after Minecraft launches
     */
    public void postInit(){

    }
}
