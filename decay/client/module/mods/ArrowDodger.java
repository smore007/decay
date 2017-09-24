package decay.client.module.mods;

import decay.client.event.events.EventPlayerUpdate;
import decay.client.logger.DecayLogger;
import decay.client.module.Module;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.math.BlockPos;
import org.lwjgl.input.Keyboard;

import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

public class ArrowDodger extends Module {

    public ArrowDodger(boolean enabled) {
        super(
                "Arrow-dodger",
                "Automatically teleport out of the way of arrows",
                Keyboard.KEY_H,
                null,
                enabled
        );
    }

    @Override
    public void onEnable() {
        // subscribe to event
        EventPlayerUpdate.INSTANCE.subscribe(this);
    }

    @Override
    public void onDisable() {
        // subscribe to event
        EventPlayerUpdate.INSTANCE.unsubscribe(this);
    }

    ArrayList<EntityArrow> dodgedArrows = new ArrayList<>();

    @Override
    public void EventPlayerUpdate() {
        for(Entity e : mc.world.loadedEntityList){
            if(e instanceof EntityArrow){
                EntityArrow arrow = (EntityArrow)e;
                if(!arrow.inGround && arrow.getDistanceToEntity(mc.player) < 3 && !dodgedArrows.contains(arrow)){

                    double[] pt = {mc.player.posX, mc.player.posZ};
                    AffineTransform.getRotateInstance(Math.toRadians(90), arrow.posX, arrow.posZ)
                            .transform(pt, 0, pt, 0, 1);

                    // check if block solid
                    if(!mc.player.world.getBlockState(new BlockPos(pt[0], mc.player.posY, pt[1])).getMaterial().isSolid()){
                        mc.player.setPosition(pt[0], mc.player.posY, pt[1]);
                        dodgedArrows.add(arrow);
                    }
                }
            }
        }
    }
}
