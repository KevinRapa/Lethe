package Study;

import A_Main.AudioPlayer;
import A_Super.Direction;
import A_Super.Room;
/**
 * Contains the first phylactery behind the painting, inside a safe.
 * Safe password in the Pi book.
 * Connects to Rotu.
 * 
 * @see Rotunda.Rotu
 * @see Study.Stud_BookPhylactery
 * @see Study.Stud_Safe
 * @see Study.Stud_PiBook
 * @author Kevin Rapa
 */
public class Stud extends Room {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Stud(String name, String ID) {
        super(name, ID);
        description= "This looks like someone's office. It's built with the same\n" +
                     "sandstone as the rest of the west wing, but the floors are\n" +
                     "dark hardwood. On the west wall is a large portrait of a\n" +
                     "middle-aged bald man. To your north is a small fireplace.\n" +
                     "Sitting in the middle of the room is a fancy desk and chair\n" +
                     "on top of a carpet. Next to the east wall is a small bookcase\n" +
                     "and a couch. Behind you, aside the door, is a black iron lever.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.SOUTH) {
            AudioPlayer.playEffect(6);
            return "The door is missing!";
        }
        else
            return bumpIntoWall(); 
    }
/*----------------------------------------------------------------------------*/
}
