package Back_Balcony;

import A_Super.Railing;

public class Bba_Rlng extends Railing {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bba_Rlng() {
        super();
        this.description = "A thick granite railing. Past it is a huge, treacherous\n"
                         + "drop into the black sea.";
        this.addNameKeys("(?:thick )?(?:stone |granite )?railing");
    }
/*----------------------------------------------------------------------------*/
}
