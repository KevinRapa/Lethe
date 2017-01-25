package A_Super;

import A_Main.NameConstants;

/**
 * Represents a class of items that are used by themselves, and that the player
 * may type "'wear' clothing name" to use them from the main prompt.
 * @author Kevin Rapa
 */
public class Clothing extends Item {
    // ========================================================================
    public Clothing(String name, String desc, String use) {
        super(name, desc, use);
        this.type = NameConstants.CLOTHING;
    }
    // ========================================================================
}
