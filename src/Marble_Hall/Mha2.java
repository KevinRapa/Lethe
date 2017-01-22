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
        description= "You stand halfway down the two-story hall. This segment is\n" +
                     "fairly similiar to the north and south ends. A chandelier\n" +
                     "hangs above you and a chair with a potted plant sit against\n" +
                     "the inner wall next to an oddly intricate pair of doors.\n" +
                     "Against the outer wall stand a pair of left and right statues\n" +
                     "below a tall window.";
    }
/*----------------------------------------------------------------------------*/
}

