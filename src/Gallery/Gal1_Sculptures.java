package Gallery;

import A_Super.Furniture;

public class Gal1_Sculptures extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal1_Sculptures() {
        super();
        this.searchable = false;
        this.description = "You quickly browse around the sculptures in the room. "
                         + "You find: "
                         + "\t\t\t<> A dragon "
                         + "\t\t\t<> A screen "
                         + "\t\t\t<> Some armor ";
        this.searchDialog = "You aren't sure which one to search first.";
        this.addNameKeys("sculptures?");
//-----------------------------------------------------------------------------
    }
}
