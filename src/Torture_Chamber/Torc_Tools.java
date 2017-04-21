package Torture_Chamber;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Torc_Tools extends Furniture {
    //-------------------------------------------------------------------------
    public Torc_Tools () {
        super();
        
        this.description = "You are trying your best not to think of what these "
                         + "were used for.";
        this.actDialog = "You don't know how to use these, and nor do you want to.";
        this.searchDialog = "You aren't sure which one to search.";

        this.addNameKeys("(?:sinister )?(?:tools?|instruments?|apparatus(?:es)?)");
        this.addActKeys("use", "play");
    }
    //-------------------------------------------------------------------------  
}


