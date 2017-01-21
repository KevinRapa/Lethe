package Vault;

import A_Super.Room;
import A_Super.Direction;
import A_Super.Furniture;
/**
 * The chalice phylactery is found in here.
 * 
 * @author Kevin Rapa
 */
public class Vau2 extends Room {
    private final Furniture Vau1_Tbl;
// ============================================================================    
    public Vau2(String name, String ID, Furniture tbl) {
        super(name, ID);
        this.Vau1_Tbl = tbl;
        this.description= "You stand at the south end of a long, low chamber. The\n" +
                          "arched ceiling curves not more than three feet over your\n" +
                          "head and gradually meets the floor on each side of you.\n" +
                          "Many chests are scattered everywhere. Piles of coins and\n" +
                          "jewels litter the floor. The room is lit by three hanging,\n" +
                          "burning steel bowls.";
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
        return this.Vau1_Tbl.containsItem("glowing chalice") ?
                this.description.concat(" Standing on a table at the far end is a glowing object.") :
                this.description;
    }
// ============================================================================    
}