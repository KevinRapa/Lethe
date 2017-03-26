package Courtyard;

import A_Super.Furniture;
import A_Super.Gettable;
/**
 * @author Kevin Rapa
 */
public class Cou_Ravens extends Furniture implements Gettable {
    // ========================================================================
    public Cou_Ravens () {
        super();
        
        this.description = "A few black ravens can be seen flying around inside "
                         + "the courtyard. Occasionally, one is seen flying into "
                         + "the nearby tree before exiting again not too long after.";
        this.actDialog = "You don't speak raven.";

        this.addNameKeys("ravens?");
        this.addActKeys("catch", "speak|talk|converse|chat|greet|listen");
    }
    // ========================================================================   
    @Override public String interact(String key) {              
        if (key.equals("catch"))
            return "You lack the reflexes to do so.";
        else if (key.matches(GETPATTERN))
            return getIt();
        else
            return this.actDialog;
    }
    // ========================================================================     
}


