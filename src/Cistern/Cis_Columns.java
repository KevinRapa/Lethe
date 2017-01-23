package Cistern;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Cis_Columns extends Furniture {
    // ========================================================================
    public Cis_Columns () {
        super();

        this.description = "The fat tiled pillars are each about 10 to 12 feet\n" +
                           "wide and extend upwards. Towards the bottom they are\n" +
                           "covered in algae. You cannot see the ceiling,\n" +
                           "for the room is too large and dark.";
        
        this.searchDialog = "You aren't wading through the disgusting water to search those.";

        this.addNameKeys("(?:fat )?(?:tiled )?(?:protruding )?(?:stone )?(?:columns?|pillars?)", "ceiling");
    }
    // ======================================================================== 
}


