package Attic;

import A_Super.Furniture;
import A_Super.Item;
import A_Super.Container;
import java.util.Random;
/**
 * @author Kevin Rapa
 */
public class Att_Css extends Furniture implements Container {
    Random generator = new Random();
    private final Item[] POSSIBILITIES = {
        new Item("lab coat", "A white lab coat", "You wear the lab coat. Now you feel ready for chemistry."),
        new Item("brown suit", "A brown wool suit jacket", "It's too hot out for this."),
        new Item("feathered hat", "A female hat with a long feather coming out the back.", "You put on the hat. Fabulous!"),
        new Item("green checkered suit", "Who would wear this?", "Maybe if it were red-checkered, you'd wear it."),
        new Item("fedora", "It's a classy suede fedora. You hope these never go out of style.", "You slip the fedora on. 'Hm... this doesn't feel right.' You take it back off."),
        new Item("dress", "It's a violet dress", "There's no time for dress up right now."),
        new Item("old rags", "Just some assorted pieces of fabric"),
        new Item("black trenchcoat", "It's a long, black wool trenchcoat.", "There's no time for dress up right now."),
        new Item("suit pants", "Some dark gray pinstripe pants", "You really don't feel like removing your pants right now.")
    };
    // ========================================================================
    public Att_Css () {
        super();
        
        this.description = "Various suitcases of different sizes lie stacked up around the attic. They seem to be filled with just clothes.";
        
        this.searchDialog = "There are plenty of suitcases. You open a few of them.";

        this.addNameKeys("(?:suit)?cas(?:es)?", "piles");
    }
    // ========================================================================   
    @Override public String getSearchDialog() {
        this.inv.contents().clear();
        
        int index = generator.nextInt(9);
        this.inv.add(POSSIBILITIES[index]);
        index = generator.nextInt(9);
        this.inv.add(POSSIBILITIES[index]);
        
        return this.searchDialog;
    }
    // ========================================================================   
}


