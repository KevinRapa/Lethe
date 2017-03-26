package Ancient_Tomb;

import A_Main.GUI;
import A_Main.Player;
import A_Super.Room;
/**
 * The two important objects in this room are Ant_NPC and Ant_Cskt.
 * The NPC gives the player a tool to find the iridescent jewel in the catacombs.
 * The casket contains the location of the iridescent jewel. To open the casket,
 * the player must find three keys hidden in parts of the catacombs.
 * Connects to An65 and Catacombs.
 * 
 * @see Catacombs.Catacomb
 * @see Ancient_Tomb.An65
 * @see Ancient_Tomb.Ant_Zombie
 * @see Ancient_Tomb.Ant_Casket
 * @author Kevin Rapa
 */
public class An55 extends Room {
// ============================================================================    
    public An55(String name, String ID) {
        super(name, ID);
    }
// ============================================================================
    @Override public String triggeredEvent() {
        if (! Player.hasVisited(ID))
            GUI.out("As you enter the room, you become immediately aware of "
                  + "a horrible figure standing on the room's opposite end. "
                  + "You freeze and stare. The figure stands perfectly still, "
                  + "his mouth gaping and eyeless face pointed right at you.");
            
        return STD_RM_OUT;
    }
// ============================================================================
}