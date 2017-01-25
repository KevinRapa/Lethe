package A_Super;

import A_Main.NameConstants;
/**
 * Something with which the player may type 'drink' [this name] at the main prompt.
 * @author Kevin Rapa
 */
public class Liquid extends Item {
    // ========================================================================
    public Liquid(String name, String desc) {
        super(name, desc);
        this.type = NameConstants.LIQUID;
    }
    // ========================================================================
    public Liquid(String name, String desc, String use) {
        super(name, desc, use);
        this.type = NameConstants.LIQUID;
    }
    // ========================================================================
    public Liquid(String name, String desc, Item forms, int threshold) {
        super(name, desc, forms, threshold);
        this.type = NameConstants.LIQUID;
    }
    // ========================================================================
}
