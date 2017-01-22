package Lichs_Quarters;

import A_Super.Room;
/**
 * The lich sleeps here mostly the whole game, and once the player destroys
 * the phylacteries, the lich is killed and the lever here may be pulled to
 * unlock the front gate.
 * Connects to Lqu1.
 * 
 * @see Lichs_Quarters.Lqu1
 * @see Lichs_Quarters.Lqu2_Lever
 * @author Kevin Rapa
 */
public class Lqu2 extends Room {
// ============================================================================    
    public Lqu2(String name, String ID) {
        super(name, ID);
        this.description= "You stand on the eastern side of the bedroom before\n" +
                          "the bed. On it, a lifeless body, seeming innocent,\n" +
                          "lays there. On the wall to the north is a lever.";
    }
// ============================================================================
}