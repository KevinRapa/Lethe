package Tower;

import A_Main.GUI;
import A_Super.Furniture;
import Lichs_Quarters.Lich_Room;
import static A_Main.Patterns.TOW1_SPHERE_P;
import A_Main.Player;
/**
 * Contains the fifth phylactery.
 * Connects to Bls1 and Foy4.
 * Accessed from a key found in Vau2 with the fourth phylactery.
 * 
 * @see Vault.Vau2
 * @see Foyer.Foy4
 * @see Black_Staircase.Bls1
 * @see Tower.Tow_ScepterPhylactery
 * @author Kevin Rapa
 */
public class Tow1 extends Lich_Room {
    private final Furniture TOW_PEDESTAL;
// ============================================================================    
    public Tow1(String name, String ID, Furniture pedestal) {
        super(name, ID);
        this.TOW_PEDESTAL = pedestal;
        this.description= "Through the door, you find yourself standing in a plain\n" +
                          "circular room with a blue and white checkered floor. Looking\n" +
                          "up, the room is a few stories high with a circular balcony\n" +
                          "wrapping around the room one story up. Wide paned windows\n" +
                          "extend along the south and east walls. On the west side\n" +
                          "is a pair of imposing black iron doors. Sitting in the\n" +
                          "center of a room is a pedestal. ";
    }
// ============================================================================
    @Override public String getDescription() {
        String result = this.description.concat(TOW_PEDESTAL.getDescription());
        
        if (! this.lichDead)
            return TOW1_SPHERE_P.matcher(result)
                    .replaceFirst(" You see a magnificent glowing sphere of light hovering in the highest area of the tower. ");
        else
            return result;
    }
// ============================================================================
    @Override public String triggeredEvent() {
        if (! Player.hasVisited(ID))
            GUI.out("As you enter the room, your head begins to throb slightly.");
            
        return STD_RM_OUT;
    }
}