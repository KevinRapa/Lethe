package Gallery;

import Super.Item;

public class Gal3_Inst extends Item {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal3_Inst (String name) {
        super(name);
        this.useID = 1;
        this.description = "The exotic instrument consists of a half-sphere for\n"
                         + "a body and a long neck. But it resembles a harp more\n"
                         + "than a guitar or cello.";
        this.useDialog = "You give it a strum. 'Sounds terrible!' you think,\n"
                       + "although you've never played a kora before. The sound\n"
                       + "itself is actually quite nice, like that of a\n"
                       + "classical guitar.";
    }
/*----------------------------------------------------------------------------*/
}