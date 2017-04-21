package Laboratory;

import A_Super.Item;
import A_Super.Moveable;
import A_Super.Openable;
import A_Super.SearchableFurniture;
/**
 * @author Kevin Rapa
 */
public class Labo_Shelf extends SearchableFurniture implements Openable, Moveable {
    //-------------------------------------------------------------------------
    public Labo_Shelf (Item... items) {
        super(items);
        
        this.description = "The metal shelf holds many different mysterious alchemical ingredients.";
        this.searchDialog = "You look on the shelves.";

        this.addNameKeys("(?:metal )?shelf");
    }
    //-------------------------------------------------------------------------   
}


