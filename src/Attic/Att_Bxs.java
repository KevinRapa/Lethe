package Attic;

import A_Super.Furniture;
import A_Super.Item;
import A_Super.Container;
import java.util.Random;
/**
 * @author Kevin Rapa
 */
public class Att_Bxs extends Furniture implements Container {
    Random generator = new Random();
    private static final Item[] POSSIBILITIES = {
        new Item("violin", "An old dusty violin. It has a string missing and sounds out of tune.", "Surely you could never play..."),
        new Item("doll", "A rag doll in a dress with one eye hanging out. Very creepy."),
        new Item("sousaphone", "You never even though theses things were real!", "You can't fit it around your waist."),
        new Item("old wooden wheel", "It's a wheel from a cart or carriage."),
        new Item("antique lamp", "A brass table lamp with a green lampshade. Its bulb is missing."),
        new Item("bed linens", "White bedsheets. They are rough and emit a musty odor.", "A good night sleep sounds pretty nice right now."),
        new Item("mirror", "It's a dusty mirror.", "You're afraid to look in it."),
        new Item("globe", "This thing doesn't at all look like modern globes. Where's Prussia?"),
    };
    // ========================================================================
    public Att_Bxs() {
        super();
        
        this.description = "There are plenty of old carboard boxes scattered\n"
                         + "around the room. They seem to be filled with various curios and science equipement.";
        this.searchDialog = "You pick a few boxes randomly and look inside.";

        this.addNameKeys("(?:cardboard )?box(?:es)?", "pile");
    }
    // ========================================================================    
    @Override public String getSearchDialog() {
        this.inv.contents().clear();
        
        int index = generator.nextInt(8);
        this.inv.add(POSSIBILITIES[index]);
        index = generator.nextInt(8);
        this.inv.add(POSSIBILITIES[index]);
        
        return this.searchDialog;
    }
    // ========================================================================    
}


