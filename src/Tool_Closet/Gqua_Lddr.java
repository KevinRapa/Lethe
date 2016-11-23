package Tool_Closet;

import Core.Player;
import Super.Staircase;

public class Gqua_Lddr extends Staircase {
    
    public Gqua_Lddr(String NAME, Player player, char direction, int height) {
        super(NAME, player, direction, height);
        String mode = direction == 'd' ? "floor" : "ceiling";
        String dir = direction == 'd' ? "down" : "up";
        
        this.description = "It's a sturdy wood ladder nailed to the wall. It\n"
                         + "leads " + dir + " a small hatch in the " + mode + ".";
        this.searchDialog = "The ladder hides nothing.";
        
        this.NAMEKEYS.clear();
        this.addNameKeys("ladder", "wood ladder", "sturdy ladder");
    }
}
