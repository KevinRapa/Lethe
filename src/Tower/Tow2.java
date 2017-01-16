package Tower;

import A_Main.GUI;
import A_Main.Id;
import A_Main.Player;
import A_Super.Item;
import Lichs_Quarters.Lich_Room;
/**
 * @author Kevin Rapa
 */
public class Tow2 extends Lich_Room {
// ============================================================================    
    public Tow2(String name, String ID) {
        super(name, ID);
        this.lichDead = false;
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
        
        return description;
    }
// ============================================================================
    @Override public String triggeredEvent() {
        if (! this.lichDead) {
            int numPhylacteries = 0;

            for (Item i : Player.getInv())
                if (i.getType().equals("phylactery"))
                    numPhylacteries++;

            if (numPhylacteries == 5) {
                Player.getRoomObj(Id.TBAL).unlock();
                GUI.out("The five etchings on the northern door are now glowing.");
            }
        }
        else
            return "The glowing sphere of light has disappeared...";
        
        return "You are " + this + ".";
    }
// ============================================================================
}
