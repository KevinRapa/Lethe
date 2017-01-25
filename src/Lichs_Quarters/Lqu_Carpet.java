package Lichs_Quarters;

import A_Super.Carpet;
/**
 * @author Kevin Rapa
 */
public class Lqu_Carpet extends Carpet {
    // ========================================================================
    public Lqu_Carpet () {
        super();

        this.description = "The lavender carpet covers much of the cold floor.";
        this.searchDialog = "You look under the carpet and find nothing.";

        this.addNameKeys("(?:lavender )?carpet");
    }
    // ========================================================================    
}


