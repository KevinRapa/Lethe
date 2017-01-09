package Attic;

import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Att_Vnts extends Furniture {

    // ========================================================================
    public Att_Vnts (Item... items) {
        super(items);
        this.searchable = false;
        
        this.description = "So many times thus far you have felt so close to\n"
                         + "the outside of this castle. The though taunts you.\n"
                         + "It's felt as though days have passed, but it's been\n"
                         + "just a few hours";

        this.addNameKeys("vents?", "moonlight");
    }
    // ======================================================================== 
}


