package East_Outer_Wall;

import Core.Player;
import Super.Staircase;

public class Eow2_Strs extends Staircase {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Eow2_Strs (String NAME, Player player, char direction, int height) {
        super(NAME, player, direction, height);
        this.description = "The curved sandstone stairs lead to a small balcony\n"
                         + "above. It's a wonder why these didn't crumble like\n"
                         + "those in the west outer wall.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        String rep = this.description;
        
        if (this.DIR == 'd') {
            rep = "The curved sandstone stairs lead down to the first floor.\n"
                + "It's a wonder why these didn't crumble like those in\n"
                + "the west outer wall.";
        }
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
