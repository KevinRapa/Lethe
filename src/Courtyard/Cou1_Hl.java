package Courtyard;

import A_Super.Furniture;
import A_Super.Item;
/**
 * Contains one of the plates needed for the observatory puzzle.
 * 
 * @see Observatory.Obs_Slts
 * @see Courtyard.Cou1_Hl
 * @author Kevin Rapa
 */
public class Cou1_Hl extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou1_Hl(Item ... items) {
        super(items);
        this.description = "It's a foot-deep hole you dug in the ground.";
        this.searchDialog = "You crouch down and reach into the hole.";
        this.actDialog = "There's no need to dig the hole any deeper.";
        this.useDialog = this.actDialog;
        this.addNameKeys("hole", "(?:foot-deep )?hole");
        this.addUseKeys("shovel", "trowel");
        this.addActKeys("dig");
    }
/*----------------------------------------------------------------------------*/    
}
