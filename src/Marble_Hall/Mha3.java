package Marble_Hall;

import A_Super.Room;
/**
 * Connects to Kitc, Eow1, and Mha2
 * 
 * @see East_Outer_Wall.Eow1
 * @see Marble_Hall.Mha2
 * @see Kitchen.Kitc
 * @author Kevin Rapa
 */
public class Mha3 extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Mha3(String name, String ID) {
        super(name, ID);
        description= 
                "This is the south end of the long hall. There's a door at "
              + "your right and a window at your left. This end is nearly a "
              + "copy of the north end. A silver chandelier hangs above you "
              + "and a chair with a potted plant sit next to the door. Yet "
              + "another door is to the south.";
    }
/*----------------------------------------------------------------------------*/
}
