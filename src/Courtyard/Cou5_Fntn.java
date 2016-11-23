package Courtyard;

import Super.Furniture;
import Super.Item;

public class Cou5_Fntn extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou5_Fntn(String NAME, Item ... items) {
        super(NAME, items);
        this.description = "This fountain is in better shape than the one at the\n"
                         + "west. A slender statue of a helmed female figure\n"
                         + "holding a staff and shield stands in the center.\n"
                         + "She resembles a soldier.";
        this.searchDialog = "You search through its basin.";
        this.addNameKeys("fountain");
    }
/*----------------------------------------------------------------------------*/
}
