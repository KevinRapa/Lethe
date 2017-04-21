package Courtyard;

import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Cou2_Fountain extends Courtyard_Fountain {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou2_Fountain(Item... items) {
        super(items);
        this.description = "What remains of the ancient fountain is just a stone "
                         + "basin and its toppled over centerpiece. It looks like "
                         + "a statue of a male figure used to stand in the center";
        this.addNameKeys("(?:toppled over )?centerpiece", "(?:male )?statue");
    }
//-----------------------------------------------------------------------------
}
