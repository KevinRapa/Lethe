package Oubliette;

import A_Super.Room;
/**
 * Superficial.
 * Connects to Cis4.
 * 
 * @see Cistern.Cis4
 * @author Kevin Rapa
 */
public class Oub1 extends Room {
// ============================================================================    
    public Oub1(String name, String ID) {
        super(name, ID);
        this.description= 
                "You are in a small round room with a pit in the center.\n" +
                "Above the pit hangs a bowl of fire. The room is otherwise\n" +
                "empty.";
    }
// ============================================================================
}