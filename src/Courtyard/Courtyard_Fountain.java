package Courtyard;

import A_Main.Player;
import A_Super.Item;
import A_Super.SearchableFurniture;
import A_Super.Unmoveable;
/**
 * @author Kevin Rapa
 */
public class Courtyard_Fountain extends SearchableFurniture implements Unmoveable {
    // ========================================================================
    public Courtyard_Fountain (Item... items) {
        super(items);
        
        this.actDialog = "There's not even any water in here!";
        this.searchDialog = "You search through its basin.";
        this.useDialog = "You better not just waste that water you brought all the way here..";

        this.addNameKeys("(?:ancient )?(?:empty)?(?:stone )?(?:fountain|basin)");
        this.addUseKeys("bucket of water", "\\w* coins?");
        this.addActKeys("swim", "drink");
    }
    // ========================================================================     
    @Override public String useEvent(Item item) {
        if (item.toString().matches("\\w* coins?")) {
            Player.getInv().give(item, this.inv);
            return "You flick the coin in and wish yourself out. Alas, you are still here.";
        }
        else
            return this.useDialog;
    }
    // ========================================================================     
}


