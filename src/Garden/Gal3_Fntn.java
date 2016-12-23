package Garden;

import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Gal3_Fntn extends Furniture {

    // ========================================================================
    public Gal3_Fntn (Item... items) {
        super(items);
        
        this.description = "The low fountain works, surprisingly, and is spouting\n"
                         + "clear water. It collects and drains from a semi-circular\n"
                         + "pool on the bottom.";
        this.actDialog = "You take a sip. Delicious! Some of the water sips into your beard though, which you find irritating.";
        this.searchDialog = "You look into the pool at the base of the fountain.";

        this.addNameKeys("fountain", "low fountain");
        this.addActKeys("drink");
    }
    // ========================================================================    
}


