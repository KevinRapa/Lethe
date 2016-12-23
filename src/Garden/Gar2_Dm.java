package Garden;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Gar2_Dm extends Furniture {
    // ========================================================================
    public Gar2_Dm () {
        super();
        this.searchable = false;
        
        this.description = "The paneled dome must be there to prevent rain from\n"
                         + "dripping into the room below. Still, why have a hole\n"
                         + "there in the first place?";

        this.addNameKeys("(?:paneled )?(?:glass )?dome");
    }
    // ======================================================================== 
}


