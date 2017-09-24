package decay.client.command.cmds;

import decay.client.command.Command;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.client.CPacketChatMessage;

public class SayCommand extends Command {

    public SayCommand() {
        super(
                "Say",
                "Say something in chat, such as a phrase starting with a '.'"
        );
    }

    @Override
    public void handle(String[] args) {
        Minecraft.getMinecraft().getConnection().sendPacket(new CPacketChatMessage(String.join(" ", args)));
    }
}
