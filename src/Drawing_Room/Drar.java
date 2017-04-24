package Drawing_Room;

import A_Main.GUI;
import A_Super.Room;
import A_Main.Player;
/**
 * Ghost NPC which the player interacts with is here.
 * All other furniture is superficial.
 * 
 * @see Drawing_Room.Drar_Ghst
 * @author Kevin Rapa
 */
public class Drar extends Room {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Drar(String name, String ID) {
        super(name, ID);
    }
//-----------------------------------------------------------------------------
    @Override public String triggeredEvent() {   
        if (! Player.hasVisited(this.ID)) 
            GUI.out("From across the room, an apparition stares at you with "
                   + "open eyes. You freeze and meet its stare with your own.");
          
        return STD_RM_OUT;
    }
//-----------------------------------------------------------------------------   
    @Override public String getDescription() {
        if (this.hasFurniture("ghost"))
            return super.getDescription();
        else
            return super.getDescription().replaceFirst(
                    "The moment.*end of the room.", 
                    "You are in a relaxing lounge. A drinking bar furnishes the south of the room.");
    }
//-----------------------------------------------------------------------------
}
