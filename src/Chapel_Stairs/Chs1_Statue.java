package Chapel_Stairs;

import A_Super.Statue;
/**
 * @author Kevin Rapa
 */
public class Chs1_Statue extends Statue {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Chs1_Statue() {
        super();
        this.description = "The female statue wears a face of sorrow and stares\n"
                         + "directly at you. As you sway from side to side, it's\n"
                         + "almost as if her eyes follow you.";
        this.actDialog = "That's not a very Christian thing to do...";
        this.addNameKeys("female statue");
    }
/*----------------------------------------------------------------------------*/
}

