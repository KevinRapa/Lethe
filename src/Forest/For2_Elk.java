package Forest;

import A_Super.Furniture;
import A_Super.Gettable;
/**
 * @author Kevin Rapa
 */
public class For2_Elk extends Furniture implements Gettable {
    //-------------------------------------------------------------------------
    public For2_Elk () {
        super();

        this.description = "The elk stands still in the distance, silently "
                + "mocking your pompous, rebellious attitude.";
        this.actDialog = "Of course I didn't program this game that way.";
        this.searchDialog = "There is definitely nothing there to search.";

        this.addNameKeys("(?:sauntering )?elk");
        this.addActKeys("ride", "eat", "kill", GETPATTERN);
    }
    //-------------------------------------------------------------------------
    @Override public String interact(String key) {              
        if (key.equals("ride"))
            return this.actDialog;
        else if (key.equals("eat"))
            return "You aren't even hungry. Stop it.";
        else if (key.equals("kill"))
            return "This is not a hunting game!";
        else
            return getIt();
    }
    //------------------------------------------------------------------------- 
}


