package Back_Hall;

import A_Super.Room;
/**
 * An 'infinitely long' hallway. Can only be traversed if the shrouded shoes
 * have been obtained by enchanting.
 * Connects to Bha1 and Obs1
 * 
 * @see Back_Hall.Bha1
 * @see Observatory.Obs1
 * @see Parlor.Par1_EnchantingTable
 * @see Back_Hall.Bha2
 * @author Kevin Rapa
 */
public class Bha1 extends Room {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bha1(String name, String ID) {
        super(name, ID);
        description= 
                 "You stand at the far west side of the hallway. You cannot\n"
               + "fathom still being in proximity to the castle, but you\n"
               + "find it best to ignore the puzzling idea. This end resembles\n"
               + "the east end closely. On the south wall is a normal door.\n"
               + "On the west wall is a plain barred window looking out to sea.";
        
    }
/*----------------------------------------------------------------------------*/
}