package Attic;

import A_Super.Item;
import A_Super.Moveable;
import A_Super.Openable;
import A_Super.SearchableFurniture;
/**
 * @author Kevin Rapa
 */
public class Att_Cases extends SearchableFurniture implements Openable, Moveable {
    // ========================================================================
    public Att_Cases (Item ... items) {
        super(items);
        
        this.description = "Various suitcases of different sizes lie stacked up around the attic. They seem to be filled with just clothes.";
        this.actDialog = "How greedy you are. Surely you couldn't carry all of these suitcases around.";
        this.searchDialog = "There are plenty of suitcases. You open a few of them at random.";

        this.addNameKeys("(?:suit)?cases?", "piles");
        this.addActKeys(GETPATTERN);
    }
    // ========================================================================     
}


