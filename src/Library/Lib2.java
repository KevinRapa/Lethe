package Library;

import A_Main.AudioPlayer;
import A_Main.Id;
import A_Main.Player;
import A_Super.Direction;
import A_Super.Room;

public class Lib2 extends Room {
    private final String DESC_MOVED;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib2(String name, String ID) {
        super(name, ID);

        description = "You're in the small north end of the library directly under\n" +
                      "the upstairs floor. In the northwest corner, a couch\n" +
                      "sits in front of a fireplace. Against the west wall is a\n" +
                      "bookshelf labeled \"Voyage\". East is a second bookshelf\n" +
                      "labeled \"Warfare\". Aside the fireplace is a small rack\n" +
                      "of shoes below a glass pane window. In the northeast\n" +
                      "corner stands a statue.";
        DESC_MOVED = "You're in the small north end of the library directly under\n" +
                     "the upstairs floor. In the northwest corner, a couch sits\n" +
                     "in front of a fireplace. Against the west wall is the\n" +
                     "displaced bookshelf labeled \"Voyage\". East is a second\n" +
                     "bookshelf labeled \"Warfare\". Aside the fireplace is a\n" +
                     "small rack of shoes below a glass pane window.\n" +
                     "In the northeast corner stands a statue.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
            return Player.getPos().isAdjacent(Id.LIB1) ? 
                    this.DESC_MOVED : 
                    this.description;
    }
/*----------------------------------------------------------------------------*/
    @Override public String getBarrier(Direction dir) {
        AudioPlayer.playEffect(6);
        
        return (dir == Direction.WEST || dir == Direction.EAST) ?
            "There's a bookshelf in the way." : WALL_BARRIER;
    }
/*----------------------------------------------------------------------------*/
}
