package Cellar;

import A_Main.AudioPlayer;
import static A_Main.Names.MONKEY_WRENCH;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Cel3_Valve extends Cel_Valve {
    private final Item WRENCH_REF;
    //-------------------------------------------------------------------------
    public Cel3_Valve (Furniture fntn, Item wrench) {
        super(fntn);
        
        this.WRENCH_REF = wrench;
        
        this.addActKeys("loosen");
    }
    //-------------------------------------------------------------------------   
    @Override public String interact(String key) {    
        if (key.equals("loosen")) {
            if (Player.getInv().contains(WRENCH_REF))
                return useEvent(WRENCH_REF);
            else
                return "That sounds quite ambitious to do by hand.";
        }
        else    
            return loosened ? super.interact(key) :
                "Applying all the brawn you can muster fails to "
                + "budge the valve. It's stuck.";
    }
    //-------------------------------------------------------------------------  
    @Override public String useEvent(Item item) {
        if (item.toString().equals(MONKEY_WRENCH)) {
            if (! loosened) {
                this.loosened = true;
                AudioPlayer.playEffect(17);
                return "You loosen the bolt some with the wrench.";
            }
            else
                return "Let's not go crazy here. The bolt is plenty loose.";
        }
        else
            return super.useEvent(item);
    }
    //-------------------------------------------------------------------------  
}


