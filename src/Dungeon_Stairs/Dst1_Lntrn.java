package Dungeon_Stairs;

import Super.Furniture;
        
public class Dst1_Lntrn extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Dst1_Lntrn(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "The old oil lantern is still lit and gives off a dim\n"
                         + "luminescence.";
        this.interactDialog = "The lantern is just out of your reach.";
        this.addActKeys("take", "grab", "remove");
        this.addNameKeys("lantern", "light");
    }
/*----------------------------------------------------------------------------*/
}
