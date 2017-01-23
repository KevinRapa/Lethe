package Courtyard;

import A_Super.Room;
/**
 * The fountain here contains a needed item for the marble hall.
 * 
 * @see Marble_Hall.Mha_Dr
 * @see Courtyard.Cou5_Fntn
 * @author Kevin Rapa
 */
public class Cou5 extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou5(String name, String ID) {
        super(name, ID);
        description= "You're in the southeast section of the courtyard.\n" +
                     "A crumbling fountain is erected at the center of this\n" +
                     "area. A helmed female statue stands in its center.\n"
                   + "Barely visible at your feet is a tiled walkway\n" +
                     "surrounding the fountain. Unkept bushes line the castle\n" +
                     "walls to the south and east, and a tall spruce tree in the\n"
                   + "corner towers over you.";
    }
/*----------------------------------------------------------------------------*/
}
