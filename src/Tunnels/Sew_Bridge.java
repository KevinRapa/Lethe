package Tunnels;

import A_Main.Player;
import A_Super.Direction;
import A_Super.Furniture;
import A_Super.Heavy;
/**
 * @author Kevin Rapa
 */
public class Sew_Bridge extends Furniture implements Heavy {
    private final Direction DIR; 
    // ========================================================================
    public Sew_Bridge (Direction dir) {
        super();

        this.DIR = dir;
        
        this.description = "The small, 11-foot stone bridge crosses over the\n" +
                           "river to another area.";
        this.searchDialog = "There's nothing on or under the bridge.";
        this.actDialog = null;

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


