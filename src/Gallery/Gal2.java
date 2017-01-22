package Gallery;

import A_Super.Room;
/**
 * Holds the statue which the player must use the crystal orb on, found in
 * lib4.
 * Connects to Gal1, Gal3, Lib3, and Mha1
 * 
 * @see Gallery.Gal1
 * @see Gallery.Gal3
 * @see Marble_Hall.Mha1
 * @see Library.Lib3
 * @see Gallery.Gal2_Statue
 * @author Kevin Rapa
 */
public class Gal2 extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal2(String name, String ID) {
        super(name, ID);
        this. description= "This circular adjoining room is actually three\n" +
                            "stories tall. You stand off-center next to curved\n" +
                            "stairs leading up to a circular second-story balcony\n" +
                            "wrapping around the perimeter of the room. In the\n" +
                            "center of this room stands a large marble statue.\n" +
                            "Columns spaced equally around the room support the\n"
                          + "balcony. A door on the north, south, and east\n"
                          + "sides of this room lead somewhere. Looking up, you\n" +
                            "see a glass dome at the top revealing the clear dark\n"
                          + "sky.";
    }
/*----------------------------------------------------------------------------*/
}
