package Garden;

import A_Super.Item;
import A_Super.SearchableFurniture;
/**
 * @author Kevin Rapa
 */
public class Gar3_Fountain extends SearchableFurniture {
    //-------------------------------------------------------------------------
    public Gar3_Fountain (Item... items) {
        super(items);
        
        this.description = "The low fountain works, surprisingly, and is spouting "
                         + "clear water. It collects and drains the water from a semi-circular "
                         + "pool at the bottom.";
        this.actDialog = "You take a sip. Delicious! Some of the water seeps "
                + "into your beard, which you have always found irritating.";
        this.searchDialog = "You look into the pool at the base of the fountain.";

        this.addNameKeys("(?:low )?fountain");
        this.addActKeys("drink", "swim", "jump");
    }
    //-------------------------------------------------------------------------
    @Override public String interact(String key) {
        return key.equals("drink") ? 
            this.actDialog :
            "You wouldn't be able to fit in there.";
    }
    //-------------------------------------------------------------------------
    @Override public String getDescription() {
        return this.inv.isEmpty() ? 
                this.description : 
                this.description.concat(" There's an object resting in it.");
    }
    //-------------------------------------------------------------------------
}


