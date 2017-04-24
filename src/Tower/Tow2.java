package Tower;

import A_Main.GUI;
import A_Main.Player;
import Lichs_Quarters.Lich_Room;
/**
 * Contains the source of the player's luring to the castle.
 * Connects to Lqu1, Bls2, and Tbal
 * 
 * @see Tower.Tow_Sphere
 * @see Top_Balcony.Tbal
 * @see Black_Staircase.Bls2
 * @see Lichs_Quarters.Lqu1
 * @author Kevin Rapa
 */
public class Tow2 extends Lich_Room {
//-----------------------------------------------------------------------------    
    public Tow2(String name, String ID) {
        super(name, ID);
    }
//-----------------------------------------------------------------------------
    @Override public String getDescription() {
        if (! this.lichDead)
            return super.getDescription()
                    .concat(" You see a magnificent glowing sphere of "
                            + "light hovering in the highest area of the tower. ");
        else
            return super.getDescription();
    }
//-----------------------------------------------------------------------------
    @Override public String triggeredEvent() {
        if (! Player.hasVisited(ID))
            GUI.out("The throbbing in your head becomes quite uncomfortable.");
        
        if (this.lichDead) 
            GUI.out("The glowing sphere of light has disappeared...");
        
        return STD_RM_OUT;
    }
//-----------------------------------------------------------------------------
}
