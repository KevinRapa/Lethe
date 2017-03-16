package Foyer;

import A_Main.AudioPlayer;
import A_Main.GUI;
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
        this.description = "The huge dim foyer is sparsely furnished and\n"
             + "clean. Despite the openness, you feel claustrophobic. A\n"
             + "red carpet is neatly layed out in the center. To\n"
             + "your west, % \n"
             + "To your east, a heavy wooden door leads somewhere else.\n"
             + "A long wood table sits in the room's center under a huge\n"
             + "chandelier and next to the front door is a lavender armoire.\n"
             + "This room extends further north to a curved staircase at the other end.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        return this.description.replaceFirst("%", descMode());
    }   
/*----------------------------------------------------------------------------*/
    private String descMode() {       
        return Player.getPos().isAdjacent(Id.FOYW) ? 
                "an opened gate leads into another room." :
                "a closed gate blocks your way into another room.";                                               
    }    
/*----------------------------------------------------------------------------*/
    @Override public String triggeredEvent() {
        if (! Player.hasVisited(ID))
            GUI.out("As you enter the spacious foyer, you recieve only the\n"
                  + "greeting of a faint musty odor lingering in the air.\n"
                  + "You carefully listen for any signs of inhabitants, but\n"
                  + "only hear the wind whistling.");
                    
        return STD_RM_OUT;
    }
/*----------------------------------------------------------------------------*/
    @Override public String getBarrier(Direction dir) {
        switch (dir) {
            case WEST:
                AudioPlayer.playEffect(4);
                return "The gate that way is closed.";
            case EAST:
                return "You should be getting out of here..."; // For end game.
            default:
                return bumpIntoWall();
        }
    }
/*----------------------------------------------------------------------------*/
}

