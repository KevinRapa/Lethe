package Escape_Tunnel;

import A_Main.Id;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Esc1_Lddr extends Furniture {
    // ========================================================================
    public Esc1_Lddr (Item... items) {
        super(items);
        this.searchable = false;
        
        this.description = "It's a metal ladder with rudimentary rungs attached\n"
                         + "directly to the stone wall.";
        this.actDialog = "You climb back up the ladder.";

        this.addNameKeys("(?:metal )?ladder");
        this.addActKeys("use", "climb", "ascend");
    }
    // ========================================================================   
    @Override public String interact(String key) {              
        Player.setOccupies(Id.INTR);
        return this.actDialog;
    }
    // ========================================================================     
}


