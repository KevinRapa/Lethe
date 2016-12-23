package Gallery;

import A_Super.Fireplace;
import A_Super.Item;

public class Gal1_Hrth extends Fireplace {
     
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Gal1_Hrth(boolean isLit, Item bckt) {       
        super(isLit, bckt);
        this.isLit = isLit;
        this.descLit = "The small hearth is tiled green and purple like the rest\n"
                     + "of the room. It's lit and it crackles.";
        this.descUnlit = "A cold, unlit fireplace.";
    }
/*----------------------------------------------------------------------------*/
}