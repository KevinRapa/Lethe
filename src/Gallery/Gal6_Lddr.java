package Gallery;

import Core.Player;
import Super.Staircase;

public class Gal6_Lddr extends Staircase {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal6_Lddr(String NAME, Player player, char direction, int height) {
        super(NAME, player, direction, height);
        this.searchDialog = "The ladder hides nothing.";
        this.description = "The ladder leads down the hatch into the room below.";
    }
/*----------------------------------------------------------------------------*/
}
