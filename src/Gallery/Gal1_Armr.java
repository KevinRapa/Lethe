package Gallery;

import Super.Furniture;

public class Gal1_Armr extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal1_Armr(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "You know a set of samurai armor when you see one.\n"
                         + "This set is mostly black and brown with gold plating\n"
                         + "on the helmet. Not as colorful as what you've seen\n"
                         + "before, but this must be the functional kind.";
        this.searchDialog = "You find many little intricate parts to this piece,\n"
                          + "but nothing removable.";
        this.interactDialog = "You will probably get hurt trying to do that.";
        this.addActKeys("wear", "equip");
        this.addNameKeys("samurai armor", "armor suit", "armor", "suit of armor"); 
/*----------------------------------------------------------------------------*/
    }
}
