package Catacombs;

import A_Super.Item;
import A_Super.SearchableFurniture;
/**
 * One of these holds the iridescent jewel.
 * 
 * @see Ancient_Tomb.Ct_Cmpss
 * @author Kevin Rapa
 */
public class Ct_Grave extends SearchableFurniture {
    //-------------------------------------------------------------------------
    public Ct_Grave (Item... items) {
        super(items);
        
        this.description = "Passed the wall, the crevice looks dug down somewhat. "
                         + "It seems to be filled with dirt and some rocks...";
        this.searchDialog = "Apprehensively, you inspect the crevice, shallowly "
                          + "digging through the dirt with your hand.";

        this.addNameKeys("(?:scattered )?(?:crevices?|graves?|holes?)");
    }
    //-------------------------------------------------------------------------    
}


