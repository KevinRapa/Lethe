package Courtyard;

import A_Super.Furniture;
import A_Super.Item;

public class Cou2_Bshs extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou2_Bshs(Item ... items) {
        super(items);
        this.description = "They're unkept thorny bushes growing red berries, and probably the only\n"
                         + "pretty things in this yard.";
        this.searchDialog = "You pick through the bushes. Ouch! You get stuck by a thorn.";
        this.actDialog = "You aren't getting pricked by those thorns.";
        this.addActKeys("grab", "hold", "touch");
        this.addNameKeys("(?:unkept )?bush(?:es)?");
    }
/*----------------------------------------------------------------------------*/
}
