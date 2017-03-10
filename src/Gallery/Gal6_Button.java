package Gallery;

import A_Main.AudioPlayer;
import A_Super.Button;
import A_Main.Player;
import java.util.Random;
import A_Main.GUI;
import A_Main.Menus;
import static A_Main.Patterns.NO_TELEPORT_P;
import static A_Main.Patterns.YES_P;
/**
 * Teleports the player to a previously visited room when pressed.
 * Superficial, not important to game progression.
 * 
 * @see Escape_Tunnel.Esc1
 * @author Kevin Rapa
 */
public class Gal6_Button extends Button {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal6_Button() {
        super();
        this.description = "It's a bright red button! Very tempting...";
        this.actDialog = "That was a smart decision.";
    }
/*----------------------------------------------------------------------------*/   
    @Override public String interact(String key) {
        return this.event(key);
    }
/*----------------------------------------------------------------------------*/    
    @Override public String event(String key) {
        int index;
        String choice, roomId;

        GUI.out("Are you really sure you want to press the button?");
        
        choice = GUI.askChoice(Menus.GAL6_BTTN, YES_NO);

        if (YES_P.matcher(choice).matches()) {
            AudioPlayer.playEffect(11);
            Random generator = new Random();

            index = generator.nextInt(Player.getVisitedRooms().size());
            roomId = Player.getVisitedRooms().get(index);

            while (NO_TELEPORT_P.matcher(roomId).matches() || 
                        roomId.equals(Player.getPosId())) 
            {
                index = generator.nextInt(Player.getVisitedRooms().size());
                roomId = Player.getVisitedRooms().get(index);
            }

            AudioPlayer.playEffect(49);
            Player.setOccupies(roomId);  

            return "'... Huh? What just happened? This isn't the gallery loft.'\n" +
                   "You scratch your head and look around the room.";
        }
        return this.actDialog;
    }
/*----------------------------------------------------------------------------*/
}
