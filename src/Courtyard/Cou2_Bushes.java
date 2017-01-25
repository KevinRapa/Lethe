package Courtyard;

import A_Main.Inventory;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Cou2_Bushes extends Courtyard_Growth {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou2_Bushes(Item ... items) {
        super();
        this.inv = new Inventory(items);
        this.description = "They're unkept thorny bushes growing red berries, and probably the only\n"
                         + "pretty things in this yard.";
        this.searchDialog = "You pick through the bushes. Ouch! You get stuck by a thorn.";
        this.actDialog = "That would probably hurt!";
        this.cutDialog = "Is the bush not tidy enough for you?";
        this.addNameKeys("(?:unkept )?(?:thorny )?bush(?:es)?", "(?:red )?berries");
    }
/*----------------------------------------------------------------------------*/
}
