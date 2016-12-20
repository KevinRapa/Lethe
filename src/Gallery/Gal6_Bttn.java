package Gallery;

import Super.Button;
import Main.Player;
import Super.Room;
import java.util.Random;
import Main.GUI;

public class Gal6_Bttn extends Button {
    private final Player REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal6_Bttn(Player plyr) {
        super();
        this.description = "It's a bright red button! Very tempting...";
        this.interactDialog = "That was a smart decision.";
        this.REF = plyr;
    }
/*----------------------------------------------------------------------------*/    
    @Override public String event(Room[][][] map, String key) {
        String rep = this.interactDialog;
        String choice;
        int X, Y, Z;
        Room room;
        
        GUI.out("Are you really sure you want to press the button?");
        do {
            choice = GUI.promptOut();
            
            if (choice.matches("yes")) {
                Random generator = new Random();
                
                do {    
                    X = generator.nextInt(8) + 1;
                    Y = generator.nextInt(6) + 1;
                    Z = generator.nextInt(2) + 2;
                    room = map[Z][Y][X];                
                } while (! REF.hasVisited(room.getID()) || room.getID().matches("STUD"));    
                
            REF.setOccupies(room);   
            rep = "'... Huh? What just happened? This isn't the gallery.'\n" +
                  "You scratch your head and look around the room. After a few\n"
                + "seconds, you're pretty sure you are back " + REF.getOcc() + ".";
            }
            
        } while (! choice.matches("yes") && ! choice.matches("no") && ! choice.matches(""));
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
