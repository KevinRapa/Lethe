package A_Super;

import static A_Main.NameConstants.BREAKABLE;

/**
 * Represents an item that can be destroyed. 
 * This can render the game unbeatable.
 * @author Kevin Rapa
 */
public class BreakableItem extends Item {
    public BreakableItem(String name, int score) {
        super(name, score);
        this.type = BREAKABLE;
    }   
    // ========================================================================       
    public BreakableItem(String name, String desc, int score) {
        super(name, desc, score);
        this.type = BREAKABLE;
    }
    // ========================================================================
    public BreakableItem(String name, String desc, String use, int score) {
        super(name, desc, use, score);
        this.type = BREAKABLE;
    }    
    // ========================================================================
    public BreakableItem(String name, Item forms, int thresh, int score) {
        super(name, forms, thresh, score);
        this.type = BREAKABLE;
    }
    // ========================================================================
    public BreakableItem(String name, String desc, Item forms, int thresh, int score) {
        super(name, desc, forms, thresh, score);
        this.type = BREAKABLE;
    }
}
