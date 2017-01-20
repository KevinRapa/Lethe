package Parlor;

import A_Super.Furniture;
import A_Super.Item;

public class Par1_Cushion extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Par1_Cushion(Item ... items) {
        super(items);
        this.description = "It's a lavender tasseled cushion for sitting on.";
        this.searchDialog = "You lift the cushion.";
        this.actDialog = "Now is not the time for that!";
        this.addNameKeys("(?:lavender )?(?:tasseled )?cushion");
        this.addActKeys("sit", "relax");
    }
/*----------------------------------------------------------------------------*/
}