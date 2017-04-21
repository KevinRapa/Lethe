package Tower;

import A_Super.Furniture;
import A_Super.Unmoveable;
/**
 * The source of the player's luring to the castle. 
 * It has an enticing glow and sound.
 * 
 * @author Kevin Rapa
 */
public class Tow_Sphere extends Furniture implements Unmoveable {
    //-------------------------------------------------------------------------
    public Tow_Sphere () {
        super();

        this.description = "The ball of bright yellow light pulses every few seconds and emits "
                         + "a dizzying low pitch. The sphere just hovers, still, high up in the center "
                         + "of the tower. The throbbing in your head exacerbates as you look. "
                         + "You are compelled to keep staring, but you pull your eyes away.";
        
        this.searchDialog = "The sphere is too high to inspect more closely.";

        this.addNameKeys("(?:hovering )?(?:glowing |pulsing )?(?:yellow )?(?:sphere|ball)(?: of (?:yellow )?light)?");
    }
    //-------------------------------------------------------------------------   
}


