package Foyer;

import A_Super.Furniture;

public class Foy1_Stairs extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
        public Foy1_Stairs() {
        super();
        this.searchable = false;
        this.description = "A winding stone staircase hugs the curved wall\n"
                         + "on the far north side of the room.";
        this.searchDialog = "It's too far away to see anything.";
        this.actDialog = "'There's no way I can walk up those from here,' you\n"
                       + "think to yourself. 'I will have to walk closer.'";
        this.addActKeys("use", "climb", "walk");
        this.addNameKeys("(?:winding )?(?:stone )?(?:staircase|stairs|steps)");
    }
/*----------------------------------------------------------------------------*/
}
