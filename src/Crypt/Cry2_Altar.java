package Crypt;

import A_Super.Item;
import A_Super.SearchableFurniture;
import A_Super.Unmoveable;
/**
 * @author Kevin Rapa
 */
public class Cry2_Altar extends SearchableFurniture implements Unmoveable {
    //-------------------------------------------------------------------------
    public Cry2_Altar (Item... items) {
        super(items);
        this.description = "The altar is essentially a stone table adorned with "
                         + "many lit candles and dried flora. A few pieces of "
                         + "jewelry are distributed about the surface.";
        this.actDialog = "You really aren't part of whatever religion this is for.";
        this.searchDialog = "You look on the altar.";

        this.addNameKeys("altar", "(?:stone )?table(?: surface)?", 
                         "candles?", "flora", "effigy", "surface");
        this.addActKeys("worship", "kneel", "sacrifice", "pray");
    }
    //-------------------------------------------------------------------------  
}


