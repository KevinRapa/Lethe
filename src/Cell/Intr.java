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
 * Connects to Esc1
 * 
 * @see Cell.Intr_Grate
 * @see Escape_Tunnel.Esc1
 * @see Laboratory.Labo
 * @author Kevin Rapa
 */
public class Intr extends Room {
//-----------------------------------------------------------------------------    
    public Intr(String name, String ID, Furniture ... furniture) {
        super(name, ID);
    }
//-----------------------------------------------------------------------------
    @Override public String triggeredEvent() {
        if (! Player.hasVisited(this.ID))
            GUI.out("An unknown amount of time passes. You awake with your head "
                    + "against a cold, wet rock floor. You manage to stand with "
                    + "some effort, and then take notice of a rattling noise. "
                    + "There's something, some kind of creature, wandering the halls outside...");
        
        return STD_RM_OUT;
    }
//-----------------------------------------------------------------------------
}