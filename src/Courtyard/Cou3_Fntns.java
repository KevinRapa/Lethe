package Courtyard;

import A_Super.Furniture;
/**
 * The fountains are not physically in COU3, but they are described there,
 * so the player should be able to reference them in some way
 * .
 * @author Kevin Rapa
 */
public class Cou3_Fntns extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou3_Fntns() {
        super();
        this.searchable = false;
        this.description = "Crumbling stone fountains to the left and right used\n"
                         + "to decorate the courtyard.";
        this.searchDialog = "They're too far away.";
        this.actDialog = this.searchDialog;
        this.addNameKeys("(?:crumbling )?(?:stone )?fountains?");
    }
/*----------------------------------------------------------------------------*/
}
