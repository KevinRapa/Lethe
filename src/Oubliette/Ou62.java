package Oubliette;

import A_Super.Room;
/**
 * Superficial.
 * Connects to catacombs.
 * Bottom level of Oub1.
 * 
 * @see Catacombs.Catacomb
 * @author Kevin Rapa
 */
public class Ou62 extends Room {
// ============================================================================    
    public Ou62(String name, String ID) {
        super(name, ID);
        this.description= 
                "You are at the bottom of a square pit, about 8 feet\n" +
                "across. You can see a hanging bowl of fire high above,\n" +
                "however barely any light reaches this area. The walls\n" +
                "and floors are cold stone brick, and it feels as\n" +
                "though the floor is covered in straw. The skeleton\n"
              + "of a forgotten soul rests on a sharp iron spike in\n"
              + "the room's center.";
    }
// ============================================================================
}