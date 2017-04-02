package Cellar;

import A_Super.Item;
import A_Super.Moveable;
import A_Super.SearchableFurniture;
/**
 * @author Kevin Rapa
 */
public class Cel4_Bed extends SearchableFurniture implements Moveable {
    // ========================================================================
    public Cel4_Bed (Item... items) {
        super(items);
        
        this.description = "The simple bed is nothing but a rudimentary metal "
                + "frame and plain white mattress. It appears heavily used, "
                + "though there is no one here.";
        this.actDialog = "It's really not the time for sleeping now.";;
        this.searchDialog = "You crouch down and look under the bed.";

        this.addNameKeys("(?:rudimentary )?bed");
        this.addActKeys(SITPATTERN);
    }
    // ========================================================================  
}


