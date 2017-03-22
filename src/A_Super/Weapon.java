package A_Super;

import A_Main.Names;

/**
 * @author Kevin Rapa
 */
public class Weapon extends Item {
    // ========================================================================
    public Weapon(String name, String desc, int score) {
        super(name, desc, score);
        this.type = Names.WEAPON;
    }
    // ========================================================================
}
