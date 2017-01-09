package Catacomb_Entrance;

import A_Super.Direction;
import A_Super.Door;
/**
 * @author Kevin Rapa
 */
public class Cs35_Dr extends Door {

    // ========================================================================
    public Cs35_Dr (Direction direction) {
        super(direction);
        
        this.description = "The door is rounded and iron, with many large rivets\n"
                         + "around the perimeter.";

        this.addNameKeys("(?:round )?(?:iron |metal )?door");
    }
    // ========================================================================     
}


