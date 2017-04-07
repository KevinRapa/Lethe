package Gallery;

import A_Main.AudioPlayer;
import static A_Main.Names.WEAPON;
import A_Super.Furniture;
import A_Super.Gettable;
import A_Super.Item;
import A_Super.Moveable;
/**
 * @author Kevin Rapa
 */
public class Gal4_Glass extends Furniture implements Gettable, Moveable {
    // ========================================================================
    public Gal4_Glass () {
        super();
        
        this.description = "It's plain glass. Looks strong though...";
        this.actDialog = "Attempts to shatter the glass are in vain. "
                + "This glass is built to last.";
        this.useDialog = this.actDialog;

        this.addNameKeys("glass");
        this.addUseKeys(ANYTHING);
        this.addActKeys("shatter", "break|destroy", JOSTLEPATTERN, GETPATTERN);
    }
    // ========================================================================   
    @Override public String interact(String key) {     
        if (key.matches(GETPATTERN))
            return getIt();
        else {
            AudioPlayer.playEffect(35);
            return this.actDialog;
        }
    }
    // ========================================================================     
    @Override public String useEvent(Item item) {
        if (item.getType().equals(WEAPON))
            return this.interact("break");
        else
            return DEFAULT_USE;
    }
    // ========================================================================     
}


