package Courtyard;

import Super.Furniture;
import Super.Item;

public class Cou2_Fntn extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou2_Fntn(String NAME, Item ... items) {
        super(NAME, items);
        this.description = "What remains of the ancient fountain is just a stone\n"
                         + "basin and its toppled over centerpiece. It looks like\n"
                         + "a statue of a male figure used to stand in the center";
        this.searchDialog = "You search through its basin.";
        this.addNameKeys("fountain");
    }
/*----------------------------------------------------------------------------*/
}
