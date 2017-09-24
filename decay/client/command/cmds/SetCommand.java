package decay.client.command.cmds;

import decay.client.command.Command;
import decay.client.module.Module;
import decay.client.module.ModuleManager;

public class SetCommand extends Command {

    public SetCommand() {
        super(
                "Set",
                "Set variable for given module"
        );
    }

    @Override
    public void handle(String[] args) {
        if(args.length < 3){
            // handle improper arguments

            return;
        }
        try{
            Module m = ModuleManager.INSTANCE.getModule(args[0]);
            if(m.args.get(args[1]) == null)
                return;
            m.args.put(args[1], args[2]);
        }catch(NullPointerException npe){
            // specified module doesn't exist
            // handle it
        }
    }
}
