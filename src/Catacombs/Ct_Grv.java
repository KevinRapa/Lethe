package Catacombs;

import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Ct_Grv extends Furniture {
    // ========================================================================
    public Ct_Grv (Item... items) {
        super(items);
        
        this.description = "Passed the wall, the crevice looks dug down somewhat.\n"
                         + "It seems to be filled with dirt and some rocks...";
        this.searchDialog = "Apprehensively, you inspect the crevice, shallowly\n"
                          + "digging through the dirt with your hand.";
        this.addNameKeys("grave", "(?:scattered )?(?:crevices|graves|holes)", "crevice", "hole");
    }
    // ========================================================================    
}


