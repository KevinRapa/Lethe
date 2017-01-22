package Trophy_Room;

import A_Super.Direction;
import A_Super.Room;
/**
 * Contains the ruby for the Jade Lion puzzle and a plate for the Statue puzzle.
 * Accessible by completing the light puzzle.
 * Connects to gal4.
 * 
 * @see Gallery.Gal_LightMachine
 * @see Gallery.Gal4
 * @see Observatory.Obs1_Statues
 * @see Jade_Hall.Jha_Lion
 * @author Kevin Rapa
 */
public class Gal5 extends Room {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal5(String name, String ID) {
        super(name, ID);
        this.description= "To your surprise, this chamber is not lavish as you\n" +
                          "expected. It looks quite abandoned. The room is dark\n" +
                          "with a low ceiling, and you can barely see a thing.\n" +
                          "The weak light shining in from the gallery illuminates\n" +
                          "a glass display in front of you. Cobwebs cover\n" +
                          "an unlit chandelier hanging above it. In a corner to the\n"
                        + "west stands a curio cabinet.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getBarrier(Direction dir) {
        return "It's pitch black, and you shouldn't wander in too far.";
    }
/*----------------------------------------------------------------------------*/
}
