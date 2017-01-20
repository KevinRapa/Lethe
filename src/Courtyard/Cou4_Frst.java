package Courtyard;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Cou4_Frst extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou4_Frst() {
        super();
        this.searchable = false;
        this.description = "All you can see is an endless dark expanse of trees.";
        this.searchDialog = "You have no business doing that.";
        this.addNameKeys("forest", "trees");
    }
/*----------------------------------------------------------------------------*/    
}
