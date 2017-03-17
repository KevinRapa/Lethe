package Oubliette;

import A_Super.Item;
import A_Super.Skeleton;
/**
 * @author Kevin Rapa
 */
public class Ou62_Skeleton extends Skeleton {
    // ========================================================================
    public Ou62_Skeleton (Item... items) {
        super(items);
        
        this.description = "The clean skeleton is well preserved and not missing\n"
                         + "a single bone. Whoever sent it down here must have\n"
                         + "forgotten about it.";
    }
    // ========================================================================
    @Override public String getDescription() {
        if (inv.contents().isEmpty())
            return this.description;
        else
            return this.description.concat(" It appears to be holding something.");
    }
    // ========================================================================        
}


