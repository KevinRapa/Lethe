package Rotunda;

import A_Super.Furniture;
/**
 * Player can escape through this from the Garden once trapped in the castle
 * rear using a leather hose.
 * 
 * @see Garden.Gar2_Hose
 * @author Kevin Rapa
 */
public class Rotu_Hole extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Rotu_Hole() {
        super();
        this.searchable = false;
        this.description = "It's a hole carved in the ceiling, about a meter\n"
                         + "wide. It looks to lead outside to the roof, although\n"
                         + "there's a glass encasing around the space above.";
        this.searchDialog = "The hole is but empty space. You have nothing to\n"
                          + "search";
        this.addNameKeys("hole");
    }
/*----------------------------------------------------------------------------*/
}
