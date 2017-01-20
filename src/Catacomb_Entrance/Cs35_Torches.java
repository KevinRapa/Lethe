package Catacomb_Entrance;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Cs35_Torches extends Furniture {
    // ========================================================================
    public Cs35_Torches () {
        super();
        this.searchable = false;
        
        this.description = "The tall obelisks burn brightly with a blue flame.";
        this.actDialog = "There's no way you are going to touch that fire.";

        this.addNameKeys("(?:standing )?torch(?:es)?", "(?:bright )?(?:blue )?flame");
        this.addActKeys("touch");
    }
    // ========================================================================      
}


