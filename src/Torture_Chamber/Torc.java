package Torture_Chamber;

import static A_Main.NameConstants.SCYTHE;
import A_Main.Player;
import A_Super.Room;
/**
 * Holds a metal ladder that the player needs to replace the pipe in SEW4 and
 * a scythe for the statue in the crypt.
 * Connects to Cry1 and Pris
 * 
 * @see Prison.Pris
 * @see Crypt.Cry1
 * @author Kevin Rapa
 */
public class Torc extends Room {
// ============================================================================    
    public Torc(String name, String ID) {
        super(name, ID);
        this.description = 
               "Many sinister tools fill this room. Center on the east wall "
             + "is a vertical wheel with many pegs around the edge. Two "
             + "sawhorses in the northwest corner support a long metal device. "
             + "Against the south wall cross a pair of wood beams. A large "
             + "scythe is displayed above it. In the center is a table fit with "
             + "many leather straps. A couple cages hang from the ceiling, and "
             + "two torches light the room on either side. A metal door leads "
             + "east here.";
    }
// ============================================================================
    @Override public String getDescription() {
        if (! Player.getPos().hasFurniture(SCYTHE))
            return this.description.replaceFirst(" A large.+above it.", "");
        else
            return this.description;
    }
// ============================================================================
}