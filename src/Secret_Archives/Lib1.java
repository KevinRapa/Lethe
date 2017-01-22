package Secret_Archives;

import A_Super.Room;
/**
 * Contains information on the light puzzle, key to the workshop, the blue focus,
 * the red lens, and story information.
 * Accessed by solving the library bookshelf puzzle.
 * Connects to Lib2.
 * 
 * @see Secret_Archives.Lib1_Schematic
 * @see Library.Lib2_VoyageShelf
 * @see Library.Lib2
 * @author Kevin Rapa
 */
public class Lib1 extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Lib1(String name, String ID) {
        super(name, ID);
        this.description = "The small secret chamber is filled with documents\n"
                         + "scattered over the furniture and floor. In the center\n" +
                           "of the room is an unkept desk and chair standing on\n" +
                           "a Persian rug. Facing west, a large window spans most\n" +
                           "of the wall to your right. Ahead of you is a rack\n" +
                           "spanning the entire wall. To your left, a strange\n" +
                           "artifact on a table emits a beam of light. The light\n" +
                           "reflects off an angled ceiling mirror onto the desk,\n" +
                           "illuminating it. Under the table, a safe sits on the\n"
                         + "floor.";
    }
/*----------------------------------------------------------------------------*/        
}