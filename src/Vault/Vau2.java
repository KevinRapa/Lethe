package Vault;

import static A_Main.NameConstants.GLOWING_CHALICE;
import A_Super.Room;
import A_Super.Direction;
import A_Super.Furniture;
/**
 * Connects to Vau1 and Vaue.
 * 
 * @see Vault.Vaue
 * @see Vault.Vau1
 * @author Kevin Rapa
 */
public class Vau2 extends Room {
    private final Furniture Vau1_Tbl;
// ============================================================================    
    public Vau2(String name, String ID, Furniture tbl) {
        super(name, ID);
        this.Vau1_Tbl = tbl;
        this.description= 
                "You stand at the south end of a long, low chamber. The\n" +
              "arched ceiling curves not more than three feet over your\n" +
              "head and gradually meets the floor on each side of you.\n" +
              "Many chests are scattered everywhere. The room is lit by "
            + "three hanging, burning steel bowls.";
    }
// ============================================================================
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.EAST || dir == Direction.WEST)
            return "The ceiling slopes down to the floor to the east and west.";
        else
            return bumpIntoWall();
    }
// ============================================================================
    @Override public String getDescription() {
        return this.Vau1_Tbl.containsItem(GLOWING_CHALICE) ?
                this.description.concat(" Standing on a table at the far end is a glowing object.") :
                this.description;
    }
// ============================================================================    
}