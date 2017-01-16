package Soul_Chamber;

import A_Super.Item;
import A_Super.Statue;
/**
 * @author Kevin Rapa
 */
public class Soul_Stats extends Statue {

    // ========================================================================
    public Soul_Stats (Item... items) {
        super(items);
        this.searchable = false;
        
        this.description = "Each tall statue is dressed in mage's garb, but looks\n"
                         + "awfully morbid; wrinkled, old, and close-to-death.";

        this.addNameKeys("(?:tall )?statues?");
    }
    // ========================================================================     
}


