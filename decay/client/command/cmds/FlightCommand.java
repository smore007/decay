package decay.client.command.cmds;

import decay.client.command.Command;
import decay.client.module.Module;
import decay.client.module.ModuleManager;
import decay.client.module.mods.Flight;

public class FlightCommand extends Command {

    public FlightCommand() {
        super(
                "Flight",
                "Set flight variables"
        );
    }

    @Override
    public void handle(String[] args) {
        if(args.length < 2){
            // handle improper args

            return;
        }
        Module m = ModuleManager.INSTANCE.getModule(Flight.class);
        if(m.args.get(args[0]) == null)
            return;
        m.args.put(args[0], args[1]);
    }
}
