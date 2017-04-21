package Cistern;

import A_Super.Column;
/**
 * @author Kevin Rapa
 */
public class Cis_Columns extends Column {
    //-------------------------------------------------------------------------
    public Cis_Columns () {
        super();

        this.description = "The fat tiled pillars are each about 10 to 12 feet " +
                           "wide and extend upwards. Towards the bottom they are " +
                           "covered in algae. You cannot see the ceiling, " +
                           "for the room is too large and dark.";
        
        this.searchDialog = "You aren't wading through the disgusting water to search those.";

        this.addNameKeys("(?:fat )?(?:tiled )?(?:protruding )?(?:stone )?(?:columns?|pillars?)", "ceiling");
    }
    //------------------------------------------------------------------------- 
}


