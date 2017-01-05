package Dungeon_Stairs;

import A_Super.Furniture;
        
public class Dst1_Lntrn extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Dst1_Lntrn() {
        super();
        this.searchable = false;
        this.description = "The old oil lantern is still lit and gives off a dim\n"
                         + "luminescence.";
        this.actDialog = "The lantern is just out of your reach.";
        this.addActKeys("take", "grab", "remove");
        this.addNameKeys("(?:hanging )?(?:oil )?(?:lantern|light)");
    }
/*----------------------------------------------------------------------------*/
}
