package Front_Balcony;

import A_Super.Door;
import A_Super.Direction;

public class Entr_Door extends Door {
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Entr_Door (Direction dir) {
        super(dir);
        this.description = "The castle's front doors are quite impressive. They "
                         + "are tall; a couple stories, and look to be made of "
                         + "pine wood with large iron hinges. Their knobs amuse "
                         + "you however, as they look way too minuscule to be "
                         + "appropriate for doors of this magnitude.";
        this.addNameKeys("front doors?");
    }
//----------------------------------------------------------------------------- 
}
