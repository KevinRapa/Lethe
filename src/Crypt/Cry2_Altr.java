package Crypt;

import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Cry2_Altr extends Furniture {
    // ========================================================================
    public Cry2_Altr (Item... items) {
        super(items);
        this.description = "The altar is on a stone table. The altar consists\n"
                         + "of many lit candles and dried flora. A few pieces of\n"
                         + "jewelry are distributed about the surface. At the\n"
                         + "center of the table is an effigy made of skull and bone.";
        this.actDialog = "Now why would you do that?";
        this.searchDialog = "You look on the altar.";

        this.addNameKeys("altar", "(?:stone )?table(?: surface)?", 
                         "candles?", "flora", "effigy", "surface");
        this.addActKeys("worship");
    }
    // ======================================================================== 
}


