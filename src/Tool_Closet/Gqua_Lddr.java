package Tool_Closet;

import Main.AudioPlayer;
import Super.Staircase;

public class Gqua_Lddr extends Staircase {
    
    public Gqua_Lddr(char direction, int height) {
        super(direction, height);
        String mode = direction == 'd' ? "floor" : "ceiling";
        String dir = direction == 'd' ? "down" : "up";
        
        this.description = "It's a sturdy wood ladder nailed to the wall. It\n"
                         + "leads " + dir + " a small hatch in the " + mode + ".";
        this.searchDialog = "The ladder hides nothing.";
        
        this.NAMEKEYS.clear();
        this.addNameKeys("ladder", "wood ladder", "sturdy ladder");
    }
    /*----------------------------------------------------------------------------*/
    @Override protected void playEffect() {
        // For overriding. Some stairs aren't wooden.
        AudioPlayer.playEffect(16);
    }
    /*----------------------------------------------------------------------------*/
}
