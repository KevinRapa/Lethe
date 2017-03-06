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
        this.description = "This room houses many sinister tools and apparatuses.\n" +
                           "Centered against the east wall is a vertical wooden\n" +
                           "wheel with many pegs around the edge. Sitting in the\n" +
                           "northwest corner are two sawhorses holding horizontally a long\n" +
                           "metal device. Against the south wall stands a pair of\n" +
                           "square wooden beams crossing each other. A large scythe is displayed on the wall above it. In the room's center\n" +
                           "is a table fit with many leather straps. A couple cages\n" +
                           "hang from the ceiling, and two torches light the room\n" +
                           "on either side. In the back east corner is a\n"
                         + "metal door.";
    }
// ============================================================================
    @Override public String getDescription() {
        if (! Player.getPos().hasFurniture(SCYTHE)) {
            return this.description.replaceFirst(" A large.+wall above it.", "");
        }
        else
            return this.description;
    }
// ============================================================================
}