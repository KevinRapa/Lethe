package Garden;

import A_Super.Item;
import A_Super.SearchableFurniture;
/**
 * @author Kevin Rapa
 */
public class Gar3_Fountain extends SearchableFurniture {
    // ========================================================================
    public Gar3_Fountain (Item... items) {
        super(items);
        
        this.description = "The low fountain works, surprisingly, and is spouting\n"
                         + "clear water. It collects and drains the water from a semi-circular\n"
                         + "pool at the bottom.";
        this.actDialog = "You take a sip. Delicious! Some of the water sips into your beard though, which you have always found irritating.";
        this.searchDialog = "You look into the pool at the base of the fountain.";

        this.addNameKeys("(?:low )?fountain");
        this.addActKeys("drink");
    }
    // ========================================================================    
}


