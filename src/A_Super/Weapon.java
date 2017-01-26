package A_Super;

import A_Main.NameConstants;

/**
 * @author Kevin Rapa
 */
public class Weapon extends Item {
    // ========================================================================
    public Weapon(String name, String desc) {
        super(name, desc);
        this.type = NameConstants.WEAPON;
    }
    // ========================================================================
}
