package Cellar;

import A_Super.Furniture;
import A_Super.Unmoveable;
/**
 * @author Kevin Rapa
 */
public class Cel2_Shaft extends Furniture implements Unmoveable {
    //-------------------------------------------------------------------------
    public Cel2_Shaft () {
        super();
        
        this.description = 
                "The smooth shaft is about two and a half feet wide and runs "
                + "through two holes barely wider than itself in the floor and "
                + "ceiling. It's still, and appears too heavy to move by hand.";
        
        this.addNameKeys("(?:smooth )?(?:wide )?(?:wooden )?shaft");
    }
    //------------------------------------------------------------------------- 
}


