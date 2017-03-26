package Garden;

/**
 * @author Kevin Rapa
 */
import A_Main.AudioPlayer;
import A_Super.Direction;
import A_Super.Room;

public class Gar4 extends Room {
// ============================================================================    
    public Gar4(String name, String ID) {
        super(name, ID);
    }
// ============================================================================
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.SOUTH) {
            AudioPlayer.playEffect(6);
            return "The door here budges only a little. Something is blocking it "
                 + "from the other side.";
        }
        else
            return bumpIntoWall();
    }
// ============================================================================
}