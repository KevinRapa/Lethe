package Gallery;

import A_Main.AudioPlayer;
import A_Super.Button;
import A_Main.Player;
import java.util.Random;
import A_Main.GUI;
/**
 * Teleports the player to a previously visited room when pressed.
 * Superficial, not important to game progression.
 * 
 * @see Escape_Tunnel.Esc1
 * @author Kevin Rapa
 */
public class Gal6_Bttn extends Button {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal6_Bttn() {
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
        GUI.menOut("\n<'y'> Push\n<'n'> Don't push\n< > Back");
        
        do {
            choice = GUI.promptOut();
            
            if (choice.matches("y|yes")) {
                AudioPlayer.playEffect(11);
                Random generator = new Random();
                
                index = generator.nextInt(Player.getVisitedRooms().size());
                roomId = Player.getVisitedRooms().get(index);
                
                while (roomId.matches("STUD|LIB[45]|LOOK|ESC\\d") || 
                       roomId.equals(Player.getPosId())) {
                    index = generator.nextInt(Player.getVisitedRooms().size());
                    roomId = Player.getVisitedRooms().get(index);
                }

                Player.setOccupies(roomId);  

                return "'... Huh? What just happened? This isn't the gallery loft.'\n" +
                       "You scratch your head and look around the room.";
            }
        } while (! choice.matches("yes|no|[yn]|"));
        
        return this.actDialog;
    }
/*----------------------------------------------------------------------------*/
}
