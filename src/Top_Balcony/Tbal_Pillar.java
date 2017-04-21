package Top_Balcony;

import A_Super.Column;
/**
 * @author Kevin Rapa
 */
public class Tbal_Pillar extends Column {
    //-------------------------------------------------------------------------
    public Tbal_Pillar () {
        super();

        this.description = "The wide column is about 20 feet wide and supports "
                         + "the enormous weight of the chamber to the north.";

        this.searchDialog = "You can't reach it from here.";

        this.addNameKeys("(?:magnificent )?(?:wide )?(?:pillar|column)");
    }
    //-------------------------------------------------------------------------   
}


