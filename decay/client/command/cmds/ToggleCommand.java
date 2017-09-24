package decay.client.command.cmds;

import decay.client.command.Command;
import decay.client.logger.DecayLogger;
import decay.client.module.ModuleManager;
import decay.client.module.mods.Flight;

public class ToggleCommand extends Command {

    public ToggleCommand() {
        super(
                "Toggle",
                "Toggles given module");
    }

    @Override
    public void handle(String[] args) {
        if(args.length < 1){
            // handle improper arguments

            return;
        }
        try{
            ModuleManager.INSTANCE.getModule(args[0]).toggleMod();
        }catch(NullPointerException npe){
            // specified module doesn't exist
            // handle it
        }
    }
}
