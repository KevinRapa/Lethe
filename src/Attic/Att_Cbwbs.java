package Attic;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Att_Cbwbs extends Furniture {

    // ========================================================================
    public Att_Cbwbs() {
        super();
        this.searchable = false;
        
        this.description = "Dust and cobwebs coat everything in this room, but not one spider is to be seen.";

        this.addNameKeys("cobwebs?", "dust");
    }
    // ========================================================================     
}


