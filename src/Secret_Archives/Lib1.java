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
        this.description = 
                "The small secret chamber is filled with documents scattered "
              + "all over. In the center of the room is an unkept desk and "
              + "chair standing on a Persian rug. A large window spans most " +
                "of the north wall. A scroll rack fills the west wall "
              + "completely. A strange artifact sits on a southern table "
              + "emitting light which reflects off an angled ceiling mirror "
              + "onto the desk. A black safe sits under the table.";
    }
/*----------------------------------------------------------------------------*/        
}