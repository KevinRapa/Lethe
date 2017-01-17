package Tunnels;

import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Sew15_Gt extends Furniture {
    // ========================================================================
    public Sew15_Gt (Item... items) {
        super(items);
        this.searchable = false;
        
        this.description = "Passed the iron gate, you can see the tunnel leading\n" +
                           "further down into darkness. The iron bars extend down\n" +
                           "into the water where they form a grate of sorts, you\n" +
                           "suppose to prevent things from... escaping\n" +
                           "unwantingly.";
        this.actDialog = "You can't get the gate open. It's locked.";
        this.searchDialog = "They're just iron bars.";

        this.addNameKeys("(?:iron )?(?:barred )?(?:gate|grate)");
        this.addActKeys("open", "close");
    }
    // ========================================================================   
    @Override public String interact(String key) {              
        if (key.equals("open"))
            return this.actDialog;
        else
            return "The gate is already closed...";
    }
    // ========================================================================     
}


