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
    }
//-----------------------------------------------------------------------------
    @Override public String getDescription() {
        return this.description.replaceFirst("%", descMode());
    }   
//-----------------------------------------------------------------------------
    private String descMode() {       
        return Player.getPos().isAdjacent(Id.FOYW) ? 
                "an opened gate leads into another room." :
                "a closed gate blocks your way into another room.";                                               
    }    
//-----------------------------------------------------------------------------
    @Override public String triggeredEvent() {
        if (! Player.hasVisited(ID))
            GUI.out("As you enter the spacious foyer, you recieve only the "
                  + "greeting of a faint musty odor lingering in the air. "
                  + "You carefully listen for any signs of inhabitants, but "
                  + "only hear the wind whistling.");
                    
        return STD_RM_OUT;
    }
//-----------------------------------------------------------------------------
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
//-----------------------------------------------------------------------------
}

