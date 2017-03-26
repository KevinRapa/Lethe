package West_Outer_Wall;

import A_Main.AudioPlayer;
import A_Main.GUI;
import A_Main.Player;
import A_Super.Direction;
import A_Super.Room;
/**
 * Player must use the fixed ladder on the floor or balcony to reach Wow3
 * 
 * @author Kevin Rapa
 */
public class Wow2 extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Wow2(String name, String ID) {
        super(name, ID);
    }  
/*----------------------------------------------------------------------------*/        
    @Override public String getBarrier(Direction dir) { 
        AudioPlayer.playEffect(6);
        
        if (dir == Direction.EAST)
            return "The door here is battered and boarded up.";
        else 
            return WALL_BARRIER;
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        if (this.hasFurniture("ladder"))
            return this.description.replaceFirst("you\\. There's", 
                    "you. A ladder now rests against the lip of the balcony. There's a boarded " +
                   "up door on the east wall of this room. There's");
        
        return this.description;
    }
/*----------------------------------------------------------------------------*/   
    @Override public String triggeredEvent() {
        if (! Player.hasVisited(ID))
            GUI.out("A comfortable ambient-warmth swarms around you as "
                    + "you enter this lofty two-story chamber.");
            
        return STD_RM_OUT;
    }
}
