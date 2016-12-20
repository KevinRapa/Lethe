package Foyer;

import Main.Player;
import Super.Staircase;

public class Foy2_Strcs extends Staircase {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Foy2_Strcs(Player player, char direction, int height) {
        super(player, direction, height);
        this.description = "A winding staircase run with red carpet all the way\n"
                         + "up. Looking straight above, it winds around you\n"
                         + "until terminating at the third floor, where it leads\n"
                         + "back to the south. Halfway up is a second\n"
                         + "floor landing to the north.";
        this.searchDialog = "In searching the stairs, you find it as clean and\n"
                          + "bare as the rest of this room.";
    }
/*----------------------------------------------------------------------------*/
}
