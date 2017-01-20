package Catacomb_Entrance;

import A_Super.Room;
/**
 * Access to catacombs, a maze complex leading to the caves.
 * 
 * @see Caves.Cave
 * @see Catacombs.Catacomb
 * @author Kevin Rapa
 */
public class Cs35 extends Room {
// ============================================================================    
    public Cs35(String name, String ID) {
        super(name, ID);
        this.description= "You stand at the bottom of the curved staircase before\n" +
                          "a round metal door. On either side, standing torches\n" +
                          "burn with in a bright blue flame. In the center of the\n" +
                          "room is a tall statue of three males standing back to back.";
    }
// ============================================================================
}