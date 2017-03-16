package Attic;

import A_Super.BreakableItem;
import A_Super.Item;
import A_Super.Moveable;
import java.util.Random;
import A_Super.Openable;
import A_Super.SearchableFurniture;
/**
 * @author Kevin Rapa
 */
public class Att_Boxes extends SearchableFurniture implements Openable, Moveable {
    Random generator = new Random();
    private static final Item[] POSSIBILITIES = {
        new BreakableItem("violin", "An old dusty violin. It has a string missing and sounds out of tune.", "Surely you could never play..."),
        new Item("doll", "A rag doll in a dress with one eye hanging out. Very creepy."),
        new BreakableItem("sousaphone", "You never even thought these things were real!", "You can't fit it around your waist."),
        new Item("old wooden wheel", "It's a wheel from a cart or carriage."),
        new BreakableItem("antique lamp", "A brass table lamp with a green lampshade. Its bulb is missing."),
        new Item("bed linens", "White bedsheets. They are rough and emit a musty odor.", "A good night's sleep sounds pretty nice right now."),
        new BreakableItem("mirror", "It's a dusty mirror.", "You're afraid to look in it."),
        new BreakableItem("globe", "This thing doesn't at all look like a modern globe. Where's Prussia?"),
    };
    // ========================================================================
    public Att_Boxes() {
        super();
        
        this.description = "There are plenty of old carboard boxes scattered\n"
                         + "around the room. They seem to be filled with various curios and science equipment.";
        this.searchDialog = "You pick a few boxes randomly and look inside.";
        this.actDialog = "You really aren't very good at folding.";
        
        this.addActKeys("fold", GETPATTERN);
        this.addNameKeys("(?:cardboard )?box(?:es)?", "pile");
        
        for (int i = 1; i <= 7; i++) {
            int index = generator.nextInt(8);
            this.inv.add(POSSIBILITIES[index]);
        }
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

