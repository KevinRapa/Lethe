package Library;

import A_Main.AudioPlayer;
import static A_Main.Names.CRYSTAL_ORB;
import A_Super.Direction;
import A_Super.Room;
import A_Super.Furniture;

public class Lib4 extends Room{
    private final Furniture REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib4(String name, String ID, Furniture tbl) {
        super(name, ID);
        this.REF = tbl;
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
        return (! REF.containsItem(CRYSTAL_ORB)) ?
            this.description.replaceFirst(" A glimmering.+them\\.", "") :
                this.description;
    }
/*----------------------------------------------------------------------------*/
}

