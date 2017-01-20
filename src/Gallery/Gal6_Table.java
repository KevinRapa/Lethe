package Gallery;

import A_Super.Furniture;

public class Gal6_Table extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal6_Table() {
        super();
        this.searchable = false;
        this.description = "Why are you so focused on an ordinary table when\n"
                         + "there's all this other stuff to look at?";
        this.searchDialog = "Nothing here but the cool thingamajig on top.";
        this.addNameKeys("table");
    }
/*----------------------------------------------------------------------------*/
}
