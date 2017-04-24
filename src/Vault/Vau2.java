package Vault;

import static A_Main.Names.GLOWING_CHALICE;
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
//-----------------------------------------------------------------------------    
    public Vau2(String name, String ID, Furniture tbl) {
        super(name, ID);
        this.Vau1_Tbl = tbl;
    }
//-----------------------------------------------------------------------------
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.EAST || dir == Direction.WEST)
            return "The ceiling slopes down to the floor to the east and west.";
        else
            return bumpIntoWall();
    }
//-----------------------------------------------------------------------------
    @Override public String getDescription() {
        return this.Vau1_Tbl.containsItem(GLOWING_CHALICE) ?
                super.getDescription().concat(" Standing on a table at the far end is a glowing object.") :
                super.getDescription();
    }
//-----------------------------------------------------------------------------    
}