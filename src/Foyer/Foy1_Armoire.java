package Foyer;

import static A_Main.NameConstants.WEAPON;
import A_Super.Item;
import A_Super.Moveable;
import A_Super.Openable;
import A_Super.SearchableFurniture;
/**
 * @author Kevin Rapa
 */
public class Foy1_Armoire extends SearchableFurniture implements Openable, Moveable {
    // ========================================================================
    public Foy1_Armoire (Item... items) {
        super(items);
        
        this.description = "The clean lavender armoire stands on four stubby legs\n"
                         + "near the south corner of the foyer. Double doors\n"
                         + "on its front conceal possibly endless riches hidden inside.";
        this.actDialog = "The armoire moves a tad from your kick. A light screech\n"
                       + "echos from the feet rubbing against the stone floor.";
        this.searchDialog = "You open up the armoire and look inside.";
        this.useDialog = "Are we feeling bloodthirsty? Or perhaps you didn't realize "
                       + "that the armoire is unlocked?";

        this.addNameKeys("(?:clean )?(?:lavender )?(?:armoire|cabinet|double doors?)");
        this.addUseKeys(ANYTHING);
        this.addActKeys(JOSTLEPATTERN);
    }
    // ========================================================================     
    @Override public String useEvent(Item item) {
        if (item.getType().equals(WEAPON))
            return this.actDialog;
        else
            return DEFAULT_USE;
    }
    // ========================================================================     
}


