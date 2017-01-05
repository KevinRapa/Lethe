package Courtyard;

import A_Super.Furniture;
import A_Super.Item;

public class Cou2_Fntn extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou2_Fntn(Item... items) {
        super(items);
        this.description = "What remains of the ancient fountain is just a stone\n"
                         + "basin and its toppled over centerpiece. It looks like\n"
                         + "a statue of a male figure used to stand in the center";
        this.searchDialog = "You search through its basin.";
        this.addNameKeys("(?:ancient )?(?:stone )?fountain");
    }
/*----------------------------------------------------------------------------*/
}
