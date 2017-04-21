package Closet;

import A_Main.AudioPlayer;
import A_Super.Direction;
import A_Super.Staircase;
/**
 * @author Kevin Rapa
 */
public class Gqua_Ladder extends Staircase {
//-----------------------------------------------------------------------------
    public Gqua_Ladder(Direction direction) {
        super(direction);
        String mode = direction == Direction.DOWN ? "floor" : "ceiling";
        
        this.description = "It's a sturdy wood ladder nailed to the wall. It "
                         + "leads " + DIR + " a small hatch in the " + mode + ".";
        
        this.NAMEKEYS.clear();
        this.addNameKeys("(?:sturdy )?(?:wood )?ladder");
    }
//-----------------------------------------------------------------------------
    @Override protected void playEffect() {
        AudioPlayer.playEffect(16);
    }
//-----------------------------------------------------------------------------
}
