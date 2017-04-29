package Lichs_Quarters;

import A_Super.Item;
import A_Super.Moveable;
import A_Super.SearchableFurniture;
/**
 * @author Kevin Rapa
 */
public class Lqu2_Bed extends SearchableFurniture implements Moveable {
    //-------------------------------------------------------------------------
    public Lqu2_Bed (Item ... items) {
        super(items);

        this.description = 
                "It seems he will not have to roam eternally in madness after all... "
                + "You suppose someone will find him eventually. "
                + "Not great to just leave a dead body alone. Oh well.";
        
        this.searchDialog = "Well, he's dead, might as well rob him!";

        this.addNameKeys("(?:lifeless )?(?:innocent )?(?:body|lich)", "bed");
    }
    //-------------------------------------------------------------------------  
}


