package Forest;

import A_Main.Id;
import A_Main.Player;
/**
 * @author Kevin Rapa
 */
public class For3 extends Forest {
//-----------------------------------------------------------------------------
    public For3(String ID) {
        super(ID);
    }
//-----------------------------------------------------------------------------
    @Override public String getDescription() {
        if (Player.getLastVisited().equals(Id.FOR2))
            return "Ah, hold on, perhaps an adventure still awaits... "
                    + "Wait for it... Alright. " + super.getDescription();
        else
            return super.getDescription();
    }
//-----------------------------------------------------------------------------
}