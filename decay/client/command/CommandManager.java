package decay.client.command;

import decay.client.command.cmds.*;
import decay.client.event.IEventHandler;
import decay.client.event.events.EventChatSend;

import java.util.ArrayList;
import java.util.Arrays;

public class CommandManager implements IEventHandler {

    public static final CommandManager INSTANCE = new CommandManager();

    public ArrayList<Command> getCommands() {
        return commands;
    }

    private ArrayList<Command> commands;

    public void init(){
        commands = new ArrayList<>();
        EventChatSend.INSTANCE.subscribe(this);

        registerCommand(new ToggleCommand());
        registerCommand(new SetCommand());
        registerCommand(new SayCommand());
        registerCommand(new FlightCommand());
        registerCommand(new VClipCommand());
    }

    public void registerCommand(Command cmd){
        commands.add(cmd);
    }

    public void unregisterCommand(Command cmd){
        commands.add(cmd);
    }

    @Override
    public boolean HandleMessage(String message) {
        boolean commandFound = false;
        if (message.startsWith(".")) {
            String[] fullMsg = message.split(" ");
            String commandName = fullMsg[0].substring(1, fullMsg[0].length());
            for (Command cmd : this.getCommands()) {
                if (cmd.name.equalsIgnoreCase(commandName)) {
                    cmd.handle(Arrays.copyOfRange(fullMsg, 1, fullMsg.length));
                    commandFound = true;
                }
            }
            if(!commandFound){
                // prefix of ".", but no command found
                // handle unknown command
            }
            return true;
        }
        return false;
    }

    @Override
    public void EventPlayerUpdate() {

    }

    @Override
    public void EventKeySend(int keyCode) {

    }

    @Override
    public void EventLivingUpdate() {

    }

    @Override
    public void EventPlayerLivingUpdate() {

    }

    @Override
    public void EventTick() {

    }
}
