package Gallery;

import A_Main.AudioPlayer;
import A_Super.Button;
import A_Main.Player;
import A_Super.Room;
import java.util.Random;
import A_Main.GUI;

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
        int X, Y, Z;
        Room room;
        
        GUI.out("Are you really sure you want to press the button?");
        do {
            choice = GUI.promptOut();
            
            if (choice.matches("yes")) {
                AudioPlayer.playEffect(11);
                Random generator = new Random();
                
                do {    
                    X = generator.nextInt(8) + 1;
                    Y = generator.nextInt(6) + 1;
                    Z = generator.nextInt(2) + 2;
                    room = Player.getMapRef()[Z][Y][X];                
                } while (! Player.hasVisited(room.getID()) || room.getID().matches("STUD|LOOK"));    
                
            Player.setOccupies(Z, Y, X);  
            GUI.roomOut(Player.getOcc().toString());
            rep = "'... Huh? What just happened? This isn't the gallery loft.'\n" +
                  "You scratch your head and look around the room. After a few\n"
                + "seconds, you're pretty sure you are back " + Player.getOcc() + ".";
            }
            
        } while (! choice.matches("yes|no|"));
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
