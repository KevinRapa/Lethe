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
        this. description = "This large circular adjoining room is three " +
                            "stories tall. You stand next to curved steps " +
                            "leading to a circular balcony supported by many " +
                            "pillars. In the room's center stands a huge " +
                            "statue, and an odd machine sits to the southeast " +
                            "Doors here lead south and east. Looking up, you\n" +
                            "see a glass dome at the top revealing the clear dark\n"
                          + "sky.";
    }
/*----------------------------------------------------------------------------*/
}
