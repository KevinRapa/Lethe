package Library;

import Main.AudioPlayer;
import Super.Room;
import Super.Furniture;

public class Lib4 extends Room{
    private final Lib4_Tbl REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib4(String name, String ID, Furniture tbl) {
        super(name, ID);
        this.REF = (Lib4_Tbl)tbl;
        description= "At the top step of the stairs, you gaze into the north end\n" +
                     "of the second floor. A couch sits in front of a fireplace in\n" +
                     "the far corner. A glimmering object catches your eye on a table\n"
                   + "between them. A bookshelf labeled \"Perdition\" is against\n" +
                     "the wall to your west. Furnished in the northeast corner is\n" +
                     "another statue. In the center of the room is a large globe.\n" +
                     "The balcony extends back south against the west wall.\n";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getBarrier(char dir) {
        String rep = "There is a wall in the way.";
        
        if (dir == 'a')
            rep = "There's a bookshelf in the way.";
        
        AudioPlayer.playEffect(6);
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        String rep = this.description;
        
        if (! REF.doesThisHaveIt("crystal orb")) {
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

