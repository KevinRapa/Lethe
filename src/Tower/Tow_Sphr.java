package Tower;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Tow_Sphr extends Furniture {
    // ========================================================================
    public Tow_Sphr () {
        super();
        this.searchable = false;
        
        this.description = "The ball of bright yellow light pulses and few seconds and emits\n"
                         + "a dizzying low pitch. The sphere just hovers, still, high up in the center\n"
                         + "of the tower. It fills you with unexplainable fear.";
        
        this.searchDialog = "The sphere is too high to inspect more closely.";

        this.addNameKeys("(?:hovering )?(?:glowing |pulsing )?(?:yellow )?(?:sphere|ball)(?: of (?:yellow )?light)?");
    }
    // ========================================================================   
}


