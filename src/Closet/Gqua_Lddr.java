package Closet;

import A_Main.AudioPlayer;
import A_Super.Direction;
import A_Super.Staircase;

public class Gqua_Lddr extends Staircase {
    
    public Gqua_Lddr(Direction direction, int height) {
        super(direction, height);
        String mode = direction == Direction.DOWN ? "floor" : "ceiling";
        
        this.description = "It's a sturdy wood ladder nailed to the wall. It\n"
                         + "leads " + DIR + " a small hatch in the " + mode + ".";
        
        this.NAMEKEYS.clear();
        this.addNameKeys("(?:sturdy )?(?:wood )?ladder");
    }
    /*------------------------------------------------------------------------*/
    @Override protected void playEffect() {
        AudioPlayer.playEffect(16);
    }
    /*------------------------------------------------------------------------*/
}
