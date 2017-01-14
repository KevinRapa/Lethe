package Gallery;

import A_Super.Furniture;
import java.util.Random;
import A_Main.GUI;
/**
 * Prints a weird dialog when worn.
 * Superficial, not important to game progression.
 * 
 * @author Kevin Rapa
 */
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
        this.actDialog = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n"
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
    @Override public String interact(String key) {
        String rep = this.actDialog;
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
