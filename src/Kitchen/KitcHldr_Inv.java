package Kitchen;

import A_Main.GUI;
import A_Main.Player;
import A_Super.Hldr_Inv;
import A_Super.Item;
/**
 * When a torch is added to or taken from this, the kitchen light is switched.
 * @author Kevin Rapa
 */
public class KitcHldr_Inv extends Hldr_Inv {
// CONSTRUCTOR -----------------------------------------------------------------      
    public KitcHldr_Inv(Item ... items) {
        super(items);
    }
/*----------------------------------------------------------------------------*/
    @Override public boolean add(Item item) { 
        if (item.toString().matches("hand torch") && this.size() == 0) {
            this.CONT.add(item);
            ((Kitc)Player.getRoomRef("KITC")).swtch();
            Player.describeRoom();
            return true;
        }
        GUI.out("The " + item + " doesn't fit in.");
        return false;
    }
/*----------------------------------------------------------------------------*/
    @Override public void remove(Item item) {
        this.CONT.remove(item);
        Player.describeRoom();
        ((Kitc)Player.getRoomRef("KITC")).swtch();
    }
/*----------------------------------------------------------------------------*/
}
