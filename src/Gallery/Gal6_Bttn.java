package Gallery;

import A_Main.AudioPlayer;
import A_Super.Button;
import A_Main.Player;
import A_Super.Room;
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
        String rep = this.actDialog;
        String choice;

        GUI.out("Are you really sure you want to press the button?");
        GUI.menOut("\n<yes> Push\n<no> Don't push\n< > Back");
        do {
            choice = GUI.promptOut();
            
            if (choice.equals("yes")) {
                Room room;
                int x, y, z;
                AudioPlayer.playEffect(11);
                Random generator = new Random();
                
                do {    
                    x = generator.nextInt(8) + 1;
                    y = generator.nextInt(6) + 1;
                    z = generator.nextInt(2) + 2;
                    room = Player.getRoomObj(z, y, x);                
                } while (! Player.hasVisited(room.getID()) || 
                        room.getID().matches("STUD|LOOK|ESC\\d"));  // Player may get trapped in STUD or LOOK  
                
                Player.setOccupies(z, y, x);  

                rep = "'... Huh? What just happened? This isn't the gallery loft.'\n" +
                      "You scratch your head and look around the room.";
            }
        } while (! choice.matches("yes|no|"));
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
