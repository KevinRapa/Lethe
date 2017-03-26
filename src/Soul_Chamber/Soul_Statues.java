package Soul_Chamber;

import A_Super.Statue;
/**
 * @author Kevin Rapa
 */
public class Soul_Statues extends Statue {
    // ========================================================================
    public Soul_Statues () {
        super();

        this.description = "Each tall statue is dressed in mage's garb, but looks "
                         + "awfully morbid; wrinkled, old, and close-to-death.";

        this.addNameKeys("(?:tall )?statues?");
    }
    // ========================================================================     
}


