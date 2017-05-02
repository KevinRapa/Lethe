package Courtyard;

import A_Main.Id;
import A_Main.Player;
import A_Super.Room;
/**
 * @author Kevin Rapa
 */
public class Cou4 extends Room {
//-----------------------------------------------------------------------------
    public Cou4(String name, String ID) {
        super(name, ID);
    }
//-----------------------------------------------------------------------------
    @Override public String getDescription() {
        if (Player.getLastVisited().equals(Id.FOR1))
            return "Okay, we're back. Now, as we were. " 
                    + super.getDescription().toUpperCase() + "LET'S GO INSIDE.";
        else
            return super.getDescription();
    }
//-----------------------------------------------------------------------------
}