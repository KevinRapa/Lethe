package Back_Hall;

import A_Super.Furniture;
import A_Super.Item;
        
public class Bha2_Frm extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bha2_Frm(Item... items) {
        super(items);
        this.description = "The picture frame is charred but still intact.";
        this.searchDialog = "You flip it over and look inside the frame.";
        this.addNameKeys("frame", "picture frame");
    }
/*----------------------------------------------------------------------------*/
}