package Cell;

import A_Main.GUI;
import A_Main.Player;
import A_Super.Room;
import A_Super.Furniture;
/**
 * Player wakes up trapped in here after laboratory puzzle.
 * Player must take the torch, lift the grate, climb down the ladder
 * to escape through small tunnels into the strange pool.
 * 
 * If the player is captured, the torch and grate in here are reset.
 * 
 * @see Laboratory.Labo
 * @author Kevin Rapa
 */
public class Intr extends Room {
// ============================================================================    
    public Intr(String name, String ID, Furniture ... furniture) {
        super(name, ID);
        
        this.description= "You wake up in a noisy chamber. A torch on the\n" +
                          "north wall lights the room just dimly enough to see.\n" +
                          "A water wheel spins on an axle spanning the length\n" +
                          "of the room. To the east is a metal door with a small\n" +
                          "window to see through. Under the door is a shallow\n" +
                          "dip through which a river of water runs. The river\n" +
                          "flows through the room and under the water wheel\n" +
                          "before depositing down a grate in the far southwest\n" +
                          "corner. Various other gears can be seen spinning in\n" +
                          "the room.";
    }
// ============================================================================
    @Override public String triggeredEvent() {
        if (! Player.hasVisited(this.ID))
            GUI.out("There's something, some kind of creature, wandering the halls outside...");
        
        return STD_RM_OUT;
    }
// ============================================================================
}