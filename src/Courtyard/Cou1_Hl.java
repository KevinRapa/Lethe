package Courtyard;

import A_Super.Furniture;
import A_Super.Item;

public class Cou1_Hl extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou1_Hl(Item ... items) {
        super(items);
        this.description = "It's a foot-deep hole you dug in the ground.";
        this.searchDialog = "You crouch down and reach into the hole.";
        this.actDialog = "There's no need to dig the hole any deeper.";
        this.useDialog = this.actDialog;
        this.addNameKeys("hole");
        this.addUseKeys("shovel", "trowel");
        this.addActKeys("dig");
    }
/*----------------------------------------------------------------------------*/    
}
