package Lichs_Quarters;

import A_Super.Furniture;
import A_Super.Openable;
/**
 * @author Kevin Rapa
 */
public class Lqu1_Chest extends Furniture implements Openable {
    // ========================================================================
    public Lqu1_Chest () {
        super();
        
        this.description = "It's a dark hickory chest.";
        this.searchDialog = "You open the chest.";

        this.addNameKeys("(?:dark )?(?:hickory |wooden )?chest");
    }
    // ======================================================================== 
}


