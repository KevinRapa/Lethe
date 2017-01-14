package Tunnels;

import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Sew_Mss extends Furniture {
    // ========================================================================
    public Sew_Mss (Item... items) {
        super(items);
        this.searchable = false;
        
        this.description = "It looks like Sphagnum- a peaty moss genus. Peaty\n" +
                           "is just how you enjoy your scotch. Briefly, the moss\n" +
                           "takes you back in memory to the rolling moors of\n" +
                           "Scotland.";

        this.addNameKeys("moss");
    }
    // ========================================================================   
}


