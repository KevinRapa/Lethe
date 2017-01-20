package Tunnels;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Sew_Moss extends Furniture {
    // ========================================================================
    public Sew_Moss () {
        super();
        this.searchable = false;
        
        this.description = "It looks like Sphagnum- a peaty moss genus. Peaty\n" +
                           "is just how you enjoy your scotch. Briefly, the moss\n" +
                           "takes you back in memory to the rolling moors of\n" +
                           "Scotland.";

        this.addNameKeys("moss");
    }
    // ========================================================================   
}


