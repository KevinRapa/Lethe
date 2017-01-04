package Front_Balcony;

import A_Super.Door;
import A_Super.Direction;

public class Entr_Dr extends Door {
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Entr_Dr (Direction dir) {
        super(dir);
        this.description = "The castle's front doors are quite impressive. They\n"
                         + "are tall; a couple stories, and look to be made of\n"
                         + "pine wood with large iron hinges. Their knobs amuse\n"
                         + "you however, as they look way too miniscule to be\n"
                         + "appropriate for doors of this magnitude.";
    }
/*----------------------------------------------------------------------------*/ 
}
