package Marble_Hall;

import A_Super.Room;
/**
 * Connects to Mha1, Din1, and Mha3.
 * Contains the angel statue puzzle, solved to obtain the angel medallion
 * for the door.
 * 
 * @see Marble_Hall.Mha2_Door
 * @see Marble_Hall.Mha2_RightStatue
 * @see Dining_Room.Din1
 * @see Marble_Hall.Mha1
 * @see Marble_Hall.Mha3
 * @author Kevin Rapa
 */
public class Mha2 extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Mha2(String name, String ID) {
        super(name, ID);
        description= 
                "You stand halfway down the two-story hall in a similar "
              + "area. A chandelier hangs above you and a chair with a "
              + "potted plant sit against the inner wall next to an "
              + "unusual pair of doors bearing slots. Against the outer "
              + "wall stand a pair of left and right angel statues below "
                + "a tall window.";
    }
/*----------------------------------------------------------------------------*/
}

