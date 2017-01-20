package Library;

import A_Main.AudioPlayer;
import static A_Main.NameConstants.CRYSTAL_ORB;
import A_Super.Direction;
import A_Super.Room;
import A_Super.Furniture;

public class Lib4 extends Room{
    private final Lib4_Table REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib4(String name, String ID, Furniture tbl) {
        super(name, ID);
        this.REF = (Lib4_Table)tbl;
        description= "At the top step of the stairs, you gaze into the north end\n" +
                     "of the second floor. A couch sits in front of a fireplace in\n" +
                     "the far corner. A glimmering object catches your eye on a table\n"
                   + "between them. A bookshelf labeled \"Perdition\" is against\n" +
                     "the wall to your west. Furnished in the northeast corner is\n" +
                     "another statue. In the center of the room is a large globe.\n" +
                     "The balcony extends back south against the west wall.\n";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.WEST) {
            AudioPlayer.playEffect(6);
            return "There's a bookshelf in the way.";
        }
        else
            return bumpIntoWall();
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        String rep = this.description;
        
        if (! REF.containsItem(CRYSTAL_ORB)) {
            rep = "At the top step of the stairs, you gaze into the north end\n" +
                  "of the second floor. A couch sits in front of a fireplace in\n" +
                  "the far corner. A bookshelf labeled \"Perdition\" is against\n" +
                  "the wall to your west. Furnished in the northeast corner is\n" +
                  "another statue. In the center of the room is a large globe.\n" +
                  "The balcony extends back south against the west wall.\n";
        }     
        return rep;
    }
/*----------------------------------------------------------------------------*/
}

