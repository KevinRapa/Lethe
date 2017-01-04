package Library;

import A_Main.AudioPlayer;
import A_Super.Direction;
import A_Super.Room;

public class Lib2 extends Room {
    private boolean shelfMoved;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib2(String name, String ID) {
        super(name, ID);
        this.shelfMoved = false;
        description= "You're in the small north end of the library directly under\n" +
                     "the upstairs floor. In the northwest corner, a fireplace\n" +
                     "crackles in front of a couch. Against the west wall is a\n" +
                     "bookshelf labeled \"Voyage\". East is a second bookshelf\n" +
                     "labeled \"Warfare\". Aside the fireplace is a small rack\n" +
                     "of shoes. Above that is a glass pane window. In the northeast\n" +
                     "corner sits a statue.";
    }
/*----------------------------------------------------------------------------*/
    public void moveShelf() {
        this.shelfMoved = true;
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        String rep = this.description;
        
        if (this.shelfMoved)
            rep = "You're in the small north end of the library directly under\n" +
                  "the upstairs floor. In the northwest corner, a fireplace\n" +
                  "crackles in front of a couch. Against the west wall is the\n" +
                  "displaced bookshelf labeled \"Voyage\". East is a second\n" +
                  "bookshelf labeled \"Warfare\". Aside the fireplace is a\n" +
                  "small rack of shoes. Above that is a glass pane window.\n" +
                  "In the northeast corner sits a small statue.";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
    @Override public String getBarrier(Direction dir) {
        AudioPlayer.playEffect(6);
        
        if (dir == Direction.WEST || dir == Direction.EAST)
            return "There's a bookshelf in the way.";

        return "There is a wall in the way.";
    }
/*----------------------------------------------------------------------------*/
}
