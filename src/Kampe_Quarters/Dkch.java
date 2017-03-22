package Kampe_Quarters;

import A_Super.Room;
/**
 * @author Kevin Rapa
 */
public class Dkch extends Room {
// ============================================================================    
    public Dkch(String name, String ID) {
        super(name, ID);
        this.description= "You have entered a small sleeping chamber no more "
                        + "than 7 or 8 feet wide.\n" +
                          "The ceiling arches to the floor on one side, and a shaft\n" +
                          "spins near the ceiling at the north end. A\n" +
                          "rudimentary bed is on the room's south side, and a plain\n" +
                          "desk and chair sit at the east. There is a lit candle\n" +
                          "on the desk.";
    }
// ============================================================================
}