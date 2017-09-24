package decay.client.command.cmds;

import decay.client.command.Command;
import net.minecraft.client.Minecraft;

public class VClipCommand extends Command {

    public VClipCommand() {
        super(
                "VClip",
                "Vertically teleport/clip given amount of blocks"
        );
    }

    @Override
    public void handle(String[] args) {

        if(args.length < 1){
            // bad args
            // handle it
        }

        try{
            Minecraft mc = Minecraft.getMinecraft();
            mc.player.setPosition(mc.player.posX, mc.player.posY + Float.parseFloat(args[0]), mc.player.posZ);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
