package Attic;

import A_Super.Item;
import A_Super.Moveable;
import A_Super.Openable;
import A_Super.SearchableFurniture;
/**
 * @author Kevin Rapa
 */
public class Att_Boxes extends SearchableFurniture implements Openable, Moveable {
    // ========================================================================
    public Att_Boxes(Item ... items) {
        super(items);
        
        this.description = "There are plenty of old cardboard boxes scattered\n"
                         + "around the room. They seem to be filled with various curios and science equipment.";
        this.searchDialog = "You pick a few boxes randomly and look inside.";
        this.actDialog = "You really aren't very good at folding.";
        
        this.addActKeys("fold", GETPATTERN);
        this.addNameKeys("(?:cardboard )?box(?:es)?", "pile");
    }
    // ========================================================================      
    @Override public String interact(String key) {
        if (key.equals("fold"))
            return this.actDialog;
        else
            return "The boxes are too large and heavy to simply put in your pocket.";
    }
    // ========================================================================
}
