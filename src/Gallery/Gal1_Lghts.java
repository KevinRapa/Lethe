package Gallery;

import A_Super.Furniture;

public class Gal1_Lghts extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal1_Lghts() {
        super();
        this.searchable = false;
        this.description = "These lights are electric. Your assumption is that\n"
                         + "this is the newer wing of the castle.";
        this.actDialog = "Ow! It's not fire, but it's still hot!";
        this.addActKeys("grab", "touch", "hold");
        this.addNameKeys("electric lights", "lights");
    }
/*----------------------------------------------------------------------------*/
}
