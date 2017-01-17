package Jade_Hall;

import A_Super.Door;
import A_Super.Direction;
/**
 * @author Kevin Rapa
 */
public class Jha_HddnDr extends Door {
    // ========================================================================
    public Jha_HddnDr (Direction dir) {
        super(dir);
        this.description = "The newly formed arched door has a blue-tint to it\n"
                         + "and bears many curved etchings. Carved in the center\n"
                         + "is a sphere with a smoke or mist rising from the top.";

        this.addNameKeys("(?:mysterious |secret |hidden )door");
    }
    // ========================================================================    
}


