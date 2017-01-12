package East_Outer_Wall;

import A_Super.Room;
/**
 * Contains a weapon rack with weapons. 
 * Weapons can be used in GAL3
 * 
 * @see East_Outer_Wall.Eow1_Rck
 * @see Gallery.Gal3_Rp
 * @author Mantis Toboggan
 */
public class Eow1 extends Room {
/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Eow1(String name, String ID) {
        super(name, ID);
        this.description = "You have a feeling you've reached the other side of\n" +
                           "the castle. This room has the same sandstone floor\n" +
                           "and walls as the west wing. You stand on the west\n" +
                           "side of the room, which extends eastwards. On the\n" +
                           "west wall is an unsettling door. Directly across from you\n" +
                           "is a rack storing an assortment of weaponry below a\n" +
                           "barred window. Next to it is a tall basket storing\n" +
                           "more of the same. Wall torches are mounted on both the\n"
                         + "north and south walls.";
    }  
/*----------------------------------------------------------------------------*/        
}

