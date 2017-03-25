package Courtyard;

import static A_Main.Names.*;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
abstract public class Courtyard_Growth extends Furniture {
    protected String cutDialog;
    // ========================================================================
    public Courtyard_Growth () {
        super();

        this.addUseKeys("\\w* (?:ax|sword)", SCYTHE, HAND_TORCH, HOE);
        this.addActKeys("grab|touch|hold", "cut|chop|prune|remove");
    }
    // ========================================================================   
    @Override public String interact(String key) {              
        if (key.matches("grab|touch|hold"))
            return this.actDialog;
        else if (Player.hasItemResembling("ax|sword|scythe"))
            return this.cutDialog;
        else
            return "You aren't a gardener!";
    }
    // ========================================================================     
    @Override public String useEvent(Item item) {
        String i = item.toString();
        
        if (i.equals(HAND_TORCH))
            return this.useDialog;
        else if (i.equals(HOE))
            return "You aren't a gardener!";
        else 
            return this.cutDialog;
    }
    // ========================================================================     
}


