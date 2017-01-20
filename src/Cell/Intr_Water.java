package Cell;

import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Intr_Water extends Furniture {
    // ========================================================================
    public Intr_Water (Item... items) {
        super(items);
        this.searchable = false;
        
        this.description = "The small river of water flows through a dip under the\n"
                         + "door. The square channel is only a couple feet wide.";
        this.actDialog = "The river is too small for your frame, and the current\n"
                       + "looks strong. There must be another way out.";

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
}


