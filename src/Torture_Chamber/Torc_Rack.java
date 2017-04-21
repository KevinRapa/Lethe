package Torture_Chamber;

import A_Super.Item;
import A_Super.Moveable;
import A_Super.SearchableFurniture;
/**
 * @author Kevin Rapa
 */
public class Torc_Rack extends SearchableFurniture implements Moveable {
    //-------------------------------------------------------------------------
    public Torc_Rack (Item... items) {
        super(items);
        
        this.description = "It's a plain wooden table, about 8 feet long, with "
                         + "no intricacies. At one end of the table is a roller "
                         + "of sorts with a crank on one side and a couple ropes "
                         + "tied around it. Along the table are several long leather "
                         + "straps and buckles. At the opposite end are two more "
                         + "short ropes.";
        this.actDialog = "The macabre idea of laying on the table dances in your "
                       + "head. You let off a sarcastic chuckle and try to forget "
                       + "about it.";
        this.searchDialog = "You look on the table.";

        this.addNameKeys("(?:plain )?(?:wooden )?(?:table|rack)");
        this.addActKeys(SITPATTERN);
    }
    //------------------------------------------------------------------------- 
}


