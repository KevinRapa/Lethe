package Gallery;

import Main.Player;
import Super.Staircase;

public class Gal2_Strcs extends Staircase {
    
    public Gal2_Strcs(Player player, char direction, int height) {
        super(player, direction, height);
        this.description = "The dark wooden stairs curve following the edge of\n"
                         + "the balcony until meeting it on the second floor.";
    }
}