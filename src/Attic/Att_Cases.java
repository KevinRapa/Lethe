package Attic;

import A_Super.Clothing;
import A_Super.Item;
import A_Super.Moveable;
import java.util.Random;
import A_Super.Openable;
import A_Super.SearchableFurniture;
/**
 * @author Kevin Rapa
 */
public class Att_Cases extends SearchableFurniture implements Openable, Moveable {
    Random generator = new Random();
    private final Item[] POSSIBILITIES = {
        new Clothing("brown suit", "A brown wool suit jacket", "It's slightly too warm and humid for this to be comfortable."),
        new Clothing("feathered hat", "A female hat with a long feather coming out the back.", "You put on the hat. How fabulous!"),
        new Clothing("green checkered suit", "Who would wear this?", "Maybe if it were red-plaid, you'd wear it."),
        new Clothing("dress", "It's a violet dress", "You aren't too accustomed to wearing dresses."),
        new Item("old rags", "Just some assorted pieces of fabric"),
        new Clothing("black trenchcoat", "It's a long, black wool trenchcoat.", "There's no time for dress up right now."),
        new Clothing("suit pants", "Some dark gray pinstripe pants", "You really don't feel like removing your pants right now.")
    };
    // ========================================================================
    public Att_Cases () {
        super();
        
        this.description = "Various suitcases of different sizes lie stacked up around the attic. They seem to be filled with just clothes.";
        
        this.searchDialog = "There are plenty of suitcases. You open a few of them at random.";

        this.addNameKeys("(?:suit)?cases?", "piles");
        
        for (int i = 1; i <= 5; i++) {
            int index = generator.nextInt(7);
            this.inv.add(POSSIBILITIES[index]);
        }
    }
    // ========================================================================     
}


