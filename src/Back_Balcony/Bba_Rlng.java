package Back_Balcony;

import A_Super.Furniture;

public class Bba_Rlng extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bba_Rlng() {
        super();
        this.description = "A thick granite railing.";
        this.actDialog = "You grab the railing, but there's no fear of falling over, right?";
        this.addActKeys("grab", "hold");
        this.addNameKeys("(?:thick )?(?:stone |granite )?railing");
    }
/*----------------------------------------------------------------------------*/
}
