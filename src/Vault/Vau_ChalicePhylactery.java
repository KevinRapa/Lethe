package Vault;

import A_Main.NameConstants;
import A_Super.Item;
/**
 * The fourth phylactery, found on a table.
 * 
 * @see Vault.Vau1_Table
 * @author Kevin Rapa
 */
public class Vau_ChalicePhylactery extends Item {
    /* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Vau_ChalicePhylactery(String name) {
        super(name);
        this.type = NameConstants.PHYLACTERY;
        
        this.description = "The enigmatic, jewel-encrusted chalice glows a light blue and emits a deep hum.";
    }
/*----------------------------------------------------------------------------*/
}
