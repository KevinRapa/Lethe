package Catacomb_Entrance;

import A_Super.Direction;
import A_Super.Door;
/**
 * @author Kevin Rapa
 */
public class Cs35_Door extends Door {
    // ========================================================================
    public Cs35_Door (Direction direction) {
        super(direction);
        
        this.description = "The door is rounded and iron, with many large rivets "
                         + "around the perimeter.";

        this.addNameKeys("(?:round )?(?:iron |metal )?door");
    }
    // ========================================================================     
}


