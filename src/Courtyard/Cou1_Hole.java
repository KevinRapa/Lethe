package Courtyard;

import static A_Main.Names.SHOVEL;
import static A_Main.Names.TROWEL;
import A_Super.Item;
import A_Super.SearchableFurniture;
/**
 * Contains one of the plates needed for the observatory puzzle.
 * 
 * @see Observatory.Obs_Slts
 * @see Courtyard.Cou1_Flr
 * @author Kevin Rapa
 */
public class Cou1_Hole extends SearchableFurniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou1_Hole(Item ... items) {
        super(items);
        this.description = "It's a foot-deep hole you dug in the ground.";
        this.searchDialog = "You crouch down and reach into the hole.";
        this.actDialog = "There's no need to dig the hole any deeper.";
        this.useDialog = this.actDialog;
        this.addNameKeys("hole", "(?:foot-deep )?hole");
        this.addUseKeys(SHOVEL, TROWEL);
        this.addActKeys("dig");
    }
/*----------------------------------------------------------------------------*/    
}
