package Cellar;

import A_Super.Furniture;
import A_Super.Gettable;
/**
 * @author Kevin Rapa
 */
public class Cel6_Pipe extends Furniture implements Gettable {
    // ========================================================================
    public Cel6_Pipe () {
        super();
        
        this.description = "The metal pipe feeding all the way down the shaft "
                + "drains here into the blackness.";
        this.actDialog = "You will need to turn the valve to do that.";

        this.addNameKeys("(?:metal )?pipe");
        this.addActKeys(GETPATTERN, "open");
    }
    // ========================================================================   
    @Override public String interact(String key) {              
        if (key.equals("open"))
            return this.actDialog;
        else
            return getIt();
    }
    // ========================================================================        
}


