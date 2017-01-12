package Back_Hall;

import A_Super.Room;
/**
 * An 'infinitely long' hallway. Can only be traversed if the shrouded shoes
 * have been obtained by enchanting.
 * 
 * @see Parlor.Par1_EnchtTbl
 * @see Back_Hall.Bha2
 * @author Kevin Rapa
 */
public class Bha1 extends Room {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bha1(String name, String ID) {
        super(name, ID);
        description= "You stand at the east end of perhaps the most bizarre\n"
                   + "hallway you have ever been in. Looking to the west, the\n"
                   + "hallway enigmatically bends downward into the earth, and\n"
                   + "the curved floor leaves a nearby 'horizon', passed which you\n"
                   + "cannot see. A deep red hue eminates from below the horizon.\n"
                   + "You almost lose your sense of position and balance. Against\n"
                   + "the nearby wall sits a quite normal drawered end table and potted plant.";
    }
/*----------------------------------------------------------------------------*/
}