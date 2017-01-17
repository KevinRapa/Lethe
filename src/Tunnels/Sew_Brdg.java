package Tunnels;

import A_Main.Player;
import A_Super.Direction;
import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Sew_Brdg extends Furniture {
    private final Direction DIR; 
    // ========================================================================
    public Sew_Brdg (Direction dir) {
        super();
        
        this.searchable = false;
        this.DIR = dir;
        
        this.description = "The small, 11-foot stone bridge crosses over the\n" +
                           "river to another area.";
        this.actDialog = null;
        this.searchDialog = "There's nothing on or under the bridge.";

        this.addNameKeys("(?:under (?:the )?)?(?:small )?(?:stone )?bridge", 
                  dir + " (?:under (?:the )?)?(?:small )?(?:stone )?bridge");
        this.addActKeys("cross");
    }
    // ========================================================================
    @Override public String interact(String key) {
        Player.move(DIR);
        return this.actDialog;  
    } 
    // ========================================================================   
}

