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
        description= "This is the south end of a library. Above you is open "
                   + "save a second floor balcony. The room is well lit with "
                   + "spherical electric sconces. In the center of this area "
                   + "is an impressive statue of a galloping horse. Against "
                   + "the east wall is a staircase below a glass paned "
                   + "window. Against the south wall, below a huge portrait, "
                   + "is a bookshelf labeled \"Creation\". A couch sits just "
                   + "in front of a large pillar against the stairs.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.SOUTH) {
            AudioPlayer.playEffect(6);
            return "There's a bookshelf in the way.";
        }
        else
            return bumpIntoWall();
    }
/*----------------------------------------------------------------------------*/
    @Override public String triggeredEvent() {
        if (! Player.hasVisited(ID))
            GUI.out("As you step foot into this room, you feel your IQ rise a few points.");
            
        return STD_RM_OUT;
    }
}

