package Forest;

import A_Main.AudioPlayer;
import A_Main.Id;
import A_Main.Player;
import A_Super.Direction;

/**
 * @author Kevin Rapa
 */
public class For1 extends Forest {
//-----------------------------------------------------------------------------
    public For1(String ID) {
        super(ID);
    }
//-----------------------------------------------------------------------------
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.NORTH) {
            Player.setOccupies(Id.COU4);
            AudioPlayer.playEffect(0);
            return "";
        }
        else
            return super.getBarrier(dir);
    }
//-----------------------------------------------------------------------------
    @Override public String getDescription() {
        if (Player.getLastVisited().equals(Id.ENDG))
            return "What are you doing? You were expected to venture forth. " 
                    + super.getDescription();
        else
            return super.getDescription();
    }
//-----------------------------------------------------------------------------
}