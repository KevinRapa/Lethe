package A_Super;

import A_Main.Names;

/**
 * Represents a class of items that are used by themselves, and that the player
 * may type "'wear' clothing name" to use them from the main prompt.
 * @author Kevin Rapa
 */
public class Clothing extends Item {
    // ========================================================================
    public Clothing(String name, String desc, String use, int score) {
        super(name, desc, use, score);
        this.type = Names.CLOTHING;
    }
    // ========================================================================
}
