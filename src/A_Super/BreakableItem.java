package A_Super;

import static A_Main.NameConstants.BREAKABLE;

/**
 * Represents an item that can be destroyed. 
 * This can render the game unbeatable.
 * @author Kevin Rapa
 */
public class BreakableItem extends Item {
    public BreakableItem(String name) {
        super(name);
        this.type = BREAKABLE;
    }   
    // ========================================================================       
    public BreakableItem(String name, String desc) {
        super(name, desc);
        this.type = BREAKABLE;
    }
    // ========================================================================
    public BreakableItem(String name, String desc, String use) {
        super(name, desc, use);
        this.type = BREAKABLE;
    }    
    // ========================================================================
    public BreakableItem(String name, Item forms, int thresh) {
        super(name, forms, thresh);
        this.type = BREAKABLE;
    }
    // ========================================================================
    public BreakableItem(String name, String desc, Item forms, int thresh) {
        super(name, desc, forms, thresh);
        this.type = BREAKABLE;
    }
}
