package West_Outer_Wall;

import A_Super.Room;
/**
 * The spoke to make the fixed ladder is here in the cart.
 * Connects to Sha1, Wbal, and Wow2
 * 
 * @see West_Outer_Wall.Wow2
 * @see West_Balcony.Wbal
 * @see Servants_Hall.Sha1
 * @author Kevin Rapa
 */
public class Wow1 extends Room {
/*----------------------------------------------------------------------------*/    
    public Wow1(String name, String ID) {
        super(name, ID);
        this.description = 
                "You stand on the west side of the large chamber, on " +
               "the other side of the hearth. Across from you, a cart " +
               "lies broken on the floor next to another window. Various "
             + "cleaning tools litter many shelves around the room. "
             + "Two doors to your north and west lead somewhere else.";
    }      
/*----------------------------------------------------------------------------*/
}

