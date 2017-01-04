package Trophy_Room;

import A_Super.Furniture;
import A_Super.Item;
        
public class Gal5_Chndlr extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal5_Chndlr(Item... items) {
        super(items);
        this.searchable = false;
        this.description = "The light holds only a few melted candles. It's\n"
                         + "covered in cobwebs. This light has not been lit\n"
                         + "for a while.";
        this.addNameKeys("chandelier", "light");
    }
/*----------------------------------------------------------------------------*/
}
