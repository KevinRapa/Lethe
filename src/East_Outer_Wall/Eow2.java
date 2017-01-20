package East_Outer_Wall;

import A_Super.Room;
/**
 * Contains a weapon rack with the silver spear, a needed item for the marble hall.
 * Contains also a cabinet with a metal bucket, a non-unique needed item.
 * Contains a fountain for filling up a bucket of water, for library
 * 
 * @see Library.Lib2
 * @see Library.Lib4
 * @see Marble_Hall.Mha_RStat
 * @see East_Outer_Wall.Water
 * @see East_Outer_Wall.Eow1_Rck    
 * @author Kevin Rapa
 */
public class Eow2 extends Room {
/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Eow2(String name, String ID) {
        super(name, ID);
        this.description = "This side of the east outer wall is two stories\n" +
                           "high. Against the north wall is a set of stairs\n" +
                           "leading up to a small balcony and a room suspended\n" +
                           "above the west side of this chamber. On the south\n" +
                           "wall is a barred window and a rack of weaponry below\n" +
                           "it. A tall cabinet stands to its east. The far east\n" +
                           "end of this area is rounded and contains a great\n" +
                           "fountain spouting clear water. A soldier statue\n"
                         + "stands on the fountain. A torch is mounted on\n"
                         + "both the north and south walls of the room.";
    }  
/*----------------------------------------------------------------------------*/        
}
