package Attic;

import A_Super.Item;
import A_Super.Moveable;
import A_Super.Openable;
import A_Super.SearchableFurniture;
/**
 * @author Kevin Rapa
 */
public class Att_Boxes extends SearchableFurniture implements Openable, Moveable {
    //-------------------------------------------------------------------------
    public Att_Boxes(Item ... items) {
        super(items);
        
        this.description = "There are plenty of old cardboard boxes scattered "
                         + "around the room. They seem to be filled with various curios and science equipment.";
        this.searchDialog = "In an excited manner reminiscent of a small child " + 
            "in a toy store, you rummage joyfully through the myterious boxes.";
        this.actDialog = "You really aren't very good at folding.";
        
        this.addActKeys("fold", GETPATTERN);
        this.addNameKeys("(?:cardboard )?box(?:es)?", "pile");
    }
    //-------------------------------------------------------------------------      
    @Override public String interact(String key) {
        if (key.equals("fold"))
            return this.actDialog;
        else
            return "The boxes are too large and heavy to simply put in your pocket.";
    }
    //-------------------------------------------------------------------------
}
