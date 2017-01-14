package Crypt;

import A_Super.Room;
/**
 * Holds the statue that the player must interact with to open the catacombs
 * entrance.
 * 
 * @see
 * @author Kevin Rapa
 */
public class Cry1 extends Room {
// ============================================================================    
    public Cry1(String name, String ID) {
        super(name, ID);
        this.description= "You stand at the south end of a long chamber. Before\n" +
                          "you stands a tall cloaked statue of a cloaked skeleton.\n" +
                          "Protrusions from the walls resembling boney arms hold\n" +
                          "up burning platters serving as torches. Arranged in a \n" +
                          "grid pattern on the east wall are numerous drawers\n" +
                          "with knobs on each. On the south wall is a carving of\n" +
                          "a depiction of death. This room extends to north.";
    }
// ============================================================================
}