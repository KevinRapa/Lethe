package Gallery;

import Super.Furniture;

public class Gal1_Lghts extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal1_Lghts(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "These lights are electric. Your assumption is that\n"
                         + "this is the newer wing of the castle.";
        this.interactDialog = "Ow! It's not fire, but it's still hot!";
        this.addActKeys("grab", "touch", "hold");
        this.addNameKeys("electric lights", "lights");
    }
/*----------------------------------------------------------------------------*/
}
