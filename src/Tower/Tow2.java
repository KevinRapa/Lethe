package Tower;

import A_Main.GUI;
import A_Main.Id;
import A_Main.NameConstants;
import A_Main.Player;
import A_Super.Item;
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
// ============================================================================    
    public Tow2(String name, String ID) {
        super(name, ID);
        this.description = "You are on the circular balcony above the lower tower floor. To the north\n" +
                           "is another imposing metal door. Some of the etchings in the door emit a\n"
                         + "bright blue luminescence. To the east on the other side of the\n" +
                           "balcony is a wood door. Wide paned windows\n" +
                           "extend along the wall to the south.";
    }
// ============================================================================
    @Override public String getDescription() {
        if (! this.lichDead)
            return description.concat(" You see a magnificent glowing sphere of light hovering in the highest area of the tower. ");
        else
            return description;
    }
// ============================================================================
    @Override public String triggeredEvent() {
        if (! Player.hasVisited(ID))
            GUI.out("The throbbing in your head becomes quite uncomfortable.");
        
        if (this.lichDead) 
            GUI.out("The glowing sphere of light has disappeared...");
        
        return STD_RM_OUT;
    }
// ============================================================================
}
