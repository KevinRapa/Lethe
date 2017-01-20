package Top_Balcony;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Tbal_Pillar extends Furniture {
    // ========================================================================
    public Tbal_Pillar () {
        super();
        this.searchable = false;
        
        this.description = "The wide column is about 20 feet wide and supports\n"
                         + "the enormous weight of the chamber to the north.";

        this.searchDialog = "You can't reach it from here.";

        this.addNameKeys("(?:wide )?(?:pillar|column)");
    }
    // ========================================================================   
}


