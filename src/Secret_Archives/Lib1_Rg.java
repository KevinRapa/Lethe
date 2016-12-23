package Secret_Archives;

import A_Super.Furniture;

public class Lib1_Rg extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib1_Rg() {
        super();
        this.searchable = false;
        this.description = "A dusty Persian rug. Clearly an antique, but it looks\n"
                         + "surprisingly new.";
        this.searchDialog = "To your great curiosity, lifting up the rug\n"
                          + "reveals a second identical rug underneath.\n"
                          + "Confused, you leave the rug alone.";
        this.addNameKeys("rug", "persian rug");
    }
/*----------------------------------------------------------------------------*/
}
