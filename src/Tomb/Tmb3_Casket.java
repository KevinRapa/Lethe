package Tomb;

import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Tmb3_Casket extends Tomb_Casket {
    // ========================================================================
    public Tmb3_Casket (Item... items) {
        super(items);
        this.searchDialog = "You slowly swing open the casket lid. There is nobody inside. "
                          + "You look at the bottom of the casket.";
    }
    // ========================================================================  
}


