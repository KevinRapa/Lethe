package Back_Hall;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Bha1_Horizon extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bha1_Horizon() {
        super();
        this.description = "The floor of the hallway warps downwards paradoxically. "
                         + "You cannot see beyond perhaps twenty feet down the hallway, "
                         + "for the floor's curvature forms a horizon.";
        this.searchDialog = "A horizon is too abstract a concept to search.";
        this.addNameKeys("horizon");
    }
/*----------------------------------------------------------------------------*/    
}
