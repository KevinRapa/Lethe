package Gallery;

import Super.Furniture;
import Super.Room;
import java.util.Random;
import Main.GUI;

public class Gal6_Hlmt extends Furniture{
    
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal6_Hlmt() {
        super();
        this.searchable = false;
        this.searchDialog = "Everything on the helmet looks concretely attached\n"
                          + "to the helmet and not removable.";
        this.description = "The metal helmet is covered in wires and metal rods.\n"
                         + "On the inside are three metal contact plates. It would\n"
                         + "not be a good idea to wear this.";
        this.interactDialog = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n"
                    + "HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH\n"
                    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n\n"
                    + "With all your strength, you rip the helmet off your head.\n"
                    + "It takes you a few moments to catch your breath and recover\n"
                    + "your sense of direction. You cannot comprehend what just\n"
                    + "happened.";
        this.addActKeys("wear");
        this.addNameKeys("helmet", "bizarre helmet");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(Room[][][] map, String key) {
        String rep = this.interactDialog;
        String choice; String r;
        
        GUI.out("Are you really sure you want to wear the helmet?");
        do {
            choice = GUI.promptOut();
            if (choice.matches("yes")) {
                Random generator = new Random();
                for (int i = 0; i < 18000; i++) {
                    r = Integer.toString(generator.nextInt(2));
                    for (int j = 0; j < 60; j++) {
                        r += Integer.toString(generator.nextInt(2));    
                    }  
                    GUI.out(r);
                }
            }
            else if (choice.matches("no") || choice.matches(""))
                rep = "That was a smart decision.";
            
        } while (! choice.matches("yes") && ! choice.matches("no") && ! choice.matches(""));
        
        return rep;
    }
}
