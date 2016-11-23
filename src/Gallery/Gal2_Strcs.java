package Gallery;

import Core.Player;
import Super.Staircase;

public class Gal2_Strcs extends Staircase {
    
    public Gal2_Strcs(String NAME, Player player, char direction, int height) {
        super(NAME, player, direction, height);
        this.description = "The dark wooden stairs curve following the edge of\n"
                         + "the balcony until meeting it on the second floor.";
        this.searchDialog = "You find nothing there.";
    }
}