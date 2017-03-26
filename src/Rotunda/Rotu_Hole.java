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

        this.description = "It's a hole carved in the ceiling, about a meter "
                         + "wide. It looks to lead outside to the roof, although "
                         + "there's a glass encasing around the space above.";
        this.actDialog = "The hole is high up in the ceiling. How would you go "
                       + "about that? Especially with your heft. Few ropes could "
                       + "support such weight.";
        this.searchDialog = "The hole is but empty space. You have nothing to search.";
        
        this.addActKeys(CLIMBPATTERN, "jump");
        this.addNameKeys("hole(?: ceiling)?");
    }
/*----------------------------------------------------------------------------*/
}
