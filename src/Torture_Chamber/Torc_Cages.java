package Torture_Chamber;

import A_Super.Item;
import A_Super.Openable;
import A_Super.SearchableFurniture;
/**
 * @author Kevin Rapa
 */
public class Torc_Cages extends SearchableFurniture implements Openable {
    // ========================================================================
    public Torc_Cages (Item... items) {
        super(items);
        
        this.description = "The small, thick-barred cages hang by chains from\n"
                         + "the ceiling. There is a small door in each. On the\n"
                         + "base of one of them sit a pile of bones.";
        this.searchDialog = "You open up one of the cages.";
        this.actDialog = "That would be uncomfortably cozy...";
         
        this.addActKeys("go", "climb", "sit");
        this.addNameKeys("(?:small )?(?:hanging )?(?:thick-barred )?cages?");
    }
    // ========================================================================   
}


