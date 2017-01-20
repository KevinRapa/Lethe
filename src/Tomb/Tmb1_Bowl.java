package Tomb;

import static A_Main.NameConstants.POLEARM;
import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Tmb1_Bowl extends Furniture {
    // ========================================================================
    public Tmb1_Bowl () {
        super();
        this.searchable = false;
        
        this.description = "The hanging steel bowl lights the room in a flickering dim light.";
        this.useDialog = "You don't think that jabbing a burning bowl is a\n"
                       + "very good idea.";

        this.addNameKeys("(?:hanging )?(?:burning )?(?:steel )?bowl(?: of fire)?");
        this.addUseKeys(POLEARM);
    }
    // ========================================================================    
}


