package Foyer;
/**
 * @author Kevin Rapa
 */
import A_Super.Room;
import A_Super.Direction;

public class Foy4 extends Room {
// ============================================================================    
    public Foy4(String name, String ID) {
        super(name, ID);
        this.description= "You stand at the top of the foyer staircase. Looking\n"
                        + "over the banister, you can see the first floor far\n"
                        + "below. Right before you to the south is a heavy wooden\n"
                        + "door.";
    }
// ============================================================================
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.WEST)
            return "There's is a banister that way.";
        
        return "There is a wall in the way.";
    }
// ============================================================================
}