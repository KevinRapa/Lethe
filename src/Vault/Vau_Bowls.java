package Vault;

import static A_Main.NameConstants.POLEARM;
import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Vau_Bowls extends Furniture {
    // ========================================================================
    public Vau_Bowls () {
        super();
        this.searchable = false;
        
        this.description = "The steel bowls hang from chains and burn. They hang\n"
                         + "lowly, as the ceiling itself is quite low too, and you\n"
                         + "must take care avoiding them.";
        this.useDialog = "You don't think that jabbing a burning bowl is a\n"
                           + "very good idea.";

        this.addNameKeys("(?:hanging )?(?:steel )?bowl(?: of fire)?", "burning bowl");
        this.addUseKeys(POLEARM);
    }
    // ========================================================================    
}


