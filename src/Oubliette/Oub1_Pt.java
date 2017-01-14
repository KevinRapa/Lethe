package Oubliette;

import A_Super.Furniture;
/**
 * Superficial. 
 * Links to Ou62 in the catacombs.
 * 
 * @see Oubliette.Ou62
 * @author Kevin Rapa
 */
public class Oub1_Pt extends Furniture {

    // ========================================================================
    public Oub1_Pt () {
        super();
        this.searchable = false;
        
        this.description = "You peer over the 8-foot wide pit. The pit empties\n"
                         + "into blackness. You cannot see the bottom.";
        this.actDialog = "That doesn't seem like a very good idea.";

        this.addNameKeys("(?:8-foot wide )?(?:pit|hole)");
        this.addActKeys("jump");
    }
    // ========================================================================      
}


