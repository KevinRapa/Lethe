package Cell;

import A_Main.Names;
import A_Super.Item;
import A_Super.Resetable;
import A_Super.SearchableFurniture;
import A_Super.Weapon;
/**
 * @author Kevin Rapa
 */
public class Intr_Water extends SearchableFurniture implements Resetable {
    private final Item METAL_BAR_REF = 
            new Weapon(Names.METAL_BAR, "A sturdy metal bar about 2 feet long. Possibly broken off from the gears.", 0);
    // ========================================================================
    public Intr_Water () {
        super();
        
        this.searchDialog = "You look in the shallow stream, near the wheel.";
        this.description = "The small river of water flows through a dip under the "
                         + "door. The square channel is only a couple feet wide.";
        this.actDialog = "The river is too small for your frame, and the current "
                       + "looks strong. There must be another way out.";

        this.inv.add(METAL_BAR_REF);
        this.addNameKeys("(?:shallow )?dip", "(?:river of )?water", "(?:square )?channel");
        this.addActKeys("drink", "jump", "swim", "escape");
    }
    // ========================================================================   
    @Override public String interact(String key) {              
        if (key.equals("drink"))
            return "You take a sip. The water is cool and tastes a little strange, but you haven't much of a care for now.";
        else
            return this.actDialog;
    }
    // ========================================================================    
    @Override public void reset() {
        if (! this.inv.contains(METAL_BAR_REF))
            this.inv.add(METAL_BAR_REF);
    }
}


