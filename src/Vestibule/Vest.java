package Vestibule;

import A_Main.AudioPlayer;
import A_Main.GUI;
import A_Main.Id;
import A_Main.Player;
import A_Super.Room;
/**
 * The first puzzle in the game, the player is locked in here upon entry and
 * must find a way out.
 * The room is escaped by opening the window and then pushing the button in
 * the back of fireplace.
 * Connects to Foy1.
 * 
 * @see Foyer.Foy1
 * @see Vestibule.Vest_Button
 * @author Kevin Rapa
 */
public class Vest extends Room {
    private boolean windowOpen;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Vest(String name, String ID) {
        super(name, ID);
        this.windowOpen = false;
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        if (! this.windowOpen)
            return this.description;
        else
            return this.description.replaceFirst("a closed", "an open");
    }
/*----------------------------------------------------------------------------*/    
    @Override public String triggeredEvent() {  
        // The check is in case player teleported here.
        if (Player.getLastVisited().equals(Id.FOY1)) {
            // Locks the door to the foyer.
            AudioPlayer.playEffect(5);
            Player.getRoomObj(Id.FOY1).lock();

            if (! Player.hasVisited(this.ID))
                GUI.out("You hear a click behind you. As you enter, you hear a "
                      + "whispering voice coming from the corner of the room. "
                      + "\'Hey! Over here, on the desk.\'");
            else
                GUI.out("You hear a click behind you.");
        }
        return STD_RM_OUT;
    }            
/*----------------------------------------------------------------------------*/
    public void switchWindow() {
        this.windowOpen = ! this.windowOpen;
    }
/*----------------------------------------------------------------------------*/    
}
