package Ancient_Tomb;

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
public class An55 extends Room {
// ============================================================================    
    public An55(String name, String ID) {
        super(name, ID);
        this.description= "You are at the north end of a long chamber with a low\n" +
                          "arched ceiling a mere foot above your head. This is clearly\n"
                        + "a tomb- an important one most likely. Your gaze\n" +
                          "is immediately drawn to something... somebody standing\n" +
                          "on the far end of the room. The room extends to the\n" +
                          "south, and a large stone casket lays in the center of\n" +
                          "the long chamber. Several other wooden caskets stand\n" +
                          "against the walls. A few torches on the walls light the\n" +
                          "room.";
    }
// ============================================================================
}