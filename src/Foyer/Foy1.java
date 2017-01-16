package Foyer;

import A_Main.Id;
import A_Main.Player;
import A_Super.Direction;
import A_Super.Room;
/**
 * Superficial. 
 * Contains a note enticing player to enter the vestibule
 * 
 * @see Vestibule.Vest
 * @author Kevin Rapa
 */
public class Foy1 extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Foy1(String name, String ID) {
        super(name, ID);   
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        return "The huge dim foyer is sparsely furnished and\n"
             + "clean. The wind whistles through the chamber past a back gate.\n"
             + "Despite the openness, you feel claustrophobic. A\n"
             + "red carpet is neatly layed out in the center. To\n"
             + "your west, " + this.descMode() + "\n"
             + "To your east, a heavy wooden door leads somewhere else.\n"
             + "A long wood table sits in the room's center under a huge\n"
             + "chandelier. This room extends further\n"
             + "north to a curved staircase at the other end.";
    }   
/*----------------------------------------------------------------------------*/
    private String descMode() {       
        return Player.getRoomObj(Id.FOYW).isThisLocked() ? 
                "a closed gate blocks your way into another room." : 
                "an opened gate leads into another room.";                                            
    }    
/*----------------------------------------------------------------------------*/
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.WEST || dir == Direction.EAST)
            return "You should be getting out of here..."; // For end game.
        else
            return bumpIntoWall();
    }
/*----------------------------------------------------------------------------*/
}

