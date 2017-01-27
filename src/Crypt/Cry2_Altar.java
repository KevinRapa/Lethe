package Crypt;

import A_Super.Item;
import A_Super.SearchableFurniture;
/**
 * @author Kevin Rapa
 */
public class Cry2_Altar extends SearchableFurniture {
    // ========================================================================
    public Cry2_Altar (Item... items) {
        super(items);
        this.description = "The altar is on a stone table. The altar consists\n"
                         + "of many lit candles and dried flora. A few pieces of\n"
                         + "jewelry are distributed about the surface. At the\n"
                         + "center of the table is an effigy made of skull and bone.";
        this.actDialog = "You really aren't part of whatever religion this is for.";
        this.searchDialog = "You look on the altar.";

        this.addNameKeys("altar", "(?:stone )?table(?: surface)?", 
                         "candles?", "flora", "effigy", "surface");
        this.addActKeys("worship", "kneel", "sacrifice");
    }
    // ========================================================================  
}


