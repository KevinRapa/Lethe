package Library;

import A_Main.AudioPlayer;
import A_Main.GUI;
import A_Main.Player;
import A_Super.Direction;
import A_Super.Room;

public class Lib3 extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib3(String name, String ID) {
        super(name, ID);
    }
//-----------------------------------------------------------------------------
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.SOUTH) {
            AudioPlayer.playEffect(6);
            return "There's a bookshelf in the way.";
        }
        else
            return bumpIntoWall();
    }
//-----------------------------------------------------------------------------
    @Override public String triggeredEvent() {
        if (! Player.hasVisited(ID))
            GUI.out("As you step foot into this room, you feel your IQ rise a few points.");
            
        return NAME;
    }
}

