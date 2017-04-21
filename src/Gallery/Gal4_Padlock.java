package Gallery;

import A_Main.AudioPlayer;
import static A_Main.Names.WEAPON;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
import Cellar.Cel5_Lock;
/**
 * @author Kevin Rapa
 */
public class Gal4_Padlock extends Cel5_Lock {
    private final Gal4_Case CASE;
    //-------------------------------------------------------------------------
    public Gal4_Padlock (Furniture casing) {
        super();
        
        this.CASE = (Gal4_Case)casing;
        
        this.description = "The padlock is sealing the door of the mounted case.";
        this.useDialog = "A nice hard smack, combined with your insatiable thirst for "
                + "good art, is enough to defeat the lock.";
    }
    //-------------------------------------------------------------------------     
    @Override public String useEvent(Item item) {
        if (item.getType().equals(WEAPON)) {
            AudioPlayer.playEffect(35);
            Player.getPos().removeFurniture(this);
            CASE.unlock();
            return this.useDialog;
        }
        else
            return super.useEvent(item);
    }
    //-------------------------------------------------------------------------     
}


