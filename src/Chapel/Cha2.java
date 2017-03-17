package Chapel;

import A_Super.Room;
/**
 * Using the Factum here will teleport the player to the vault.
 * Connects to Cha1 and Vaue
 * 
 * @see Chapel.Cha1
 * @see Caves.Factum
 * @see Vault.Vaue
 * @author Kevin Rapa
 */
public class Cha2 extends Room {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cha2(String name, String ID) {
        super(name, ID);
        description= 
                "You climb up to the chapel's altar in the chancel to the south.";
    }
/*----------------------------------------------------------------------------*/
}
