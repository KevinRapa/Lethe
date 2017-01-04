package Garden;

/**
 * @author Kevin Rapa
 */
import A_Main.AudioPlayer;
import A_Super.Direction;
import A_Super.Room;

public class Gar1 extends Room {
// ============================================================================    
    public Gar1(String name, String ID) {
        super(name, ID);
        this.description= "You're in the northwest quarter of the garden. Past\n" +
                          "a planter extending along the railing to the west is\n" +
                          "a view of the massive sea aside the long cliff to the\n" +
                          "south. A statue stands in the northwest corner against\n" +
                          "the railing.";
    }
// ============================================================================
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.WEST)
            return "There's about a 150 foot drop right there.";
        
        AudioPlayer.playEffect(6);
        return "There is a wall in the way";

    }
// ============================================================================
}