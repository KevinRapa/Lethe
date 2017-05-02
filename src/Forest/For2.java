package Forest;

import A_Main.Id;
import A_Main.Player;
/**
 * @author Kevin Rapa
 */
public class For2 extends Forest {
//-----------------------------------------------------------------------------    
    public For2(String ID) {
        super(ID);
    }
//-----------------------------------------------------------------------------
    @Override public String getDescription() {
        if (Player.getLastVisited().equals(Id.FOR1))
            return "Did you not read the last description? This isn't what "
                    + "you are supposed to do. " + super.getDescription();
        else
            return "Yes, indeed. Let's make our way back to the castle and "
                    + "stop this nonsense. " + super.getDescription();
    }
//-----------------------------------------------------------------------------
}