package Vault;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Vau_Bwls extends Furniture {
    // ========================================================================
    public Vau_Bwls () {
        super();
        this.searchable = false;
        
        this.description = "The steel bowls hang from chains and burn. They hang\n"
                         + "very low, as the ceiling itself is quite low too, and you\n"
                         + "must take care avoiding them.";
        this.useDialog = "You don't think that jabbing a burning bowl is a\n"
                           + "very good idea.";

        this.addNameKeys("(?:hanging )?(?:steel )?bowl(?: of fire)?", "burning bowl");
        this.addUseKeys("polearm");
    }
    // ========================================================================    
}


