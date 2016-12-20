package Courtyard;

import Super.Furniture;

public class Cou_Cstl extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou_Cstl() {
        super();
        this.searchable = false;
        this.description = "The monstrous castle appears ghastly standing in the\n"
                         + "night. Scanning it thoroughly, you figure it to be\n"
                         + "about four or five stories tall. The castle looks to\n"
                         + "be composed of a central area and a wing on each side.";
        this.searchDialog = "Maybe you should go inside to do that.";
        this.addNameKeys("castle");
    }
/*----------------------------------------------------------------------------*/
}

