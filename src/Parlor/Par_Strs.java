package Parlor;

import Main.Player;
import Super.Staircase;

public class Par_Strs extends Staircase {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Par_Strs (Player player, char direction, int height) {
        super(player, direction, height);
        this.description = "The thin sandstone stairs lead to the balcony above.\n";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        String rep = this.description;
        
        if (this.DIR == 'd') {
            rep = "The thin sandstone stairs lead down to the first floor.";
        }
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
