package Closet;

import A_Main.AudioPlayer;
import A_Super.Staircase;

public class Gqua_Lddr extends Staircase {
    
    public Gqua_Lddr(char direction, int height) {
        super(direction, height);
        String mode = direction == 'd' ? "floor" : "ceiling";
        String dir = direction == 'd' ? "down" : "up";
        
        this.description = "It's a sturdy wood ladder nailed to the wall. It\n"
                         + "leads " + dir + " a small hatch in the " + mode + ".";
        
        this.NAMEKEYS.clear();
        this.addNameKeys("(?:sturdy )?(?:wood )?ladder");
    }
    /*------------------------------------------------------------------------*/
    @Override protected void playEffect() {
        AudioPlayer.playEffect(16);
    }
    /*------------------------------------------------------------------------*/
}
