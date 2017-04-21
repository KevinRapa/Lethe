package Drawing_Room;

import A_Main.AudioPlayer;
import static A_Main.Names.WEAPON;
import A_Super.Furniture;
import A_Super.Item;
import A_Super.Unmoveable;
/**
 * @author Kevin Rapa
 */
public class Drar_Piano extends Furniture implements Unmoveable {
    //-------------------------------------------------------------------------
    public Drar_Piano () {
        super();
        
        this.description = "The wooden upright piano sits against the wall. The "
                         + "paint has begun to chip, but the piano still appears "
                         + "functional. A couple keys on the piano have gone missing.";
        this.actDialog = "Egh... sounds terrible. You're no musician.";
        this.useDialog = "You aren't sure what useful task would get done from that.";

        this.addNameKeys("(?:upright )?(?:brown )?piano", "(?:piano )?keys?");
        this.addUseKeys(ANYTHING);
        this.addActKeys("play", "press", SITPATTERN);
    }
    //-------------------------------------------------------------------------   
    @Override public String interact(String key) {              
        AudioPlayer.playEffect(53);
        return this.actDialog;
    }
    //-------------------------------------------------------------------------     
    @Override public String useEvent(Item item) {
        if (item.getType().equals(WEAPON))
            return "Now why would you want to destroy such a beautiful instrument?";
        else
            return this.useDialog;
    }
    //-------------------------------------------------------------------------     
}


