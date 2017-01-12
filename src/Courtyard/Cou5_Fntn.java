package Courtyard;

import A_Super.Furniture;
import A_Super.Item;
/**
 * Contains the stone disk, needed for the door in the marble hall
 * 
 * @see Marble_Hall.Mha_Dr
 * @author Kevin Rapa
 */
public class Cou5_Fntn extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou5_Fntn(Item... items) {
        super(items);
        this.description = "This fountain is in better shape than the one at the\n"
                         + "west. A slender statue of a helmed female figure\n"
                         + "holding a staff and shield stands in the center.\n"
                         + "She resembles a soldier.";
        this.searchDialog = "You search through its basin.";
        this.addNameKeys("(?:stone )?fountain");
    }
/*----------------------------------------------------------------------------*/
}
