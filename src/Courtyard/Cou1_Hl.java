package Courtyard;

import Super.Furniture;
import Super.Item;

public class Cou1_Hl extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou1_Hl(Item ... items) {
        super(items);
        this.description = "It's a foot-deep hole you dug in the ground.";
        this.searchDialog = "You crouch down and reach into the hole.";
        this.interactDialog = "There's no need to dig the hole any deeper.";
        this.useDialog = this.interactDialog;
        this.addNameKeys("hole");
        this.addUseKeys("shovel");
        this.addActKeys("dig");
    }
/*----------------------------------------------------------------------------*/    
}
