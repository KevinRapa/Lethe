package Vault;

import A_Super.Room;
/**
 * The player is teleported here by using the Factum in the chapel at the altar.
 * A door puzzle must be solved which gives entry to Vau1 and Vau2. The chalice
 * phylactery is found there.
 * 
 * @author Kevin Rapa
 */
public class Vaue extends Room {
// ============================================================================    
    public Vaue(String name, String ID) {
        super(name, ID);
        this.description= "You are in a square sandstone chamber before a huge\n" +
                          "circular door to the north.";
    }
// ============================================================================
}