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
        description= "You stand at the south end of the long hall facing north \n" +
                     "with a door at your right and a window at your left. This\n" +
                     "end is nearly a copy of the north end. A silver chandelier\n" +
                     "hangs above you and a chair with a plant sit next to the\n" +
                     "door. Another door to the south leads somewhere else.";
    }
/*----------------------------------------------------------------------------*/
}
