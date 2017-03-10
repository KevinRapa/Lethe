package Ancient_Tomb;

import A_Main.GUI;
import A_Main.Player;
import A_Super.Room;
/**
 * The two important objects in this room are Ant_NPC and Ant_Cskt.
 * The NPC gives the player a tool to find the iridescent jewel in the catacombs.
 * The casket contains the location of the iridescent jewel. To open the casket,
 * the player must find three keys hidden in parts of the catacombs.
 * 
 * @see Ancient_Tomb.Ant_NPC
 * @see Ancient_Tomb.Ant_Cskt
 * @author Kevin Rapa
 */
public class An65 extends Room {
// ============================================================================    
    public An65(String name, String ID) {
        super(name, ID);
        this.description= "You stand uncomfortably on the south end of the long\n" +
                          "room. In the corner stands the dessicated, but alive figure, staring\n" +
                          "at you blankly with its mouth hung open and not moving.\n" +
                          "This end is also lit with a few wall torches. A heavy\n" +
                          "stone casket lies in the center of the room, and several\n" +
                          "other wooden caskets lean on the walls.";
    }
// ============================================================================
    @Override public String triggeredEvent() {
        if (! Player.hasVisited(ID))
            GUI.out("You step closer to the zombie-like figure. It remains still, "
                  + "swaying slightly with its attention drawn to you.");
            
        return STD_RM_OUT;
    }
}