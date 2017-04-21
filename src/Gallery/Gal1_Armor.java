package Gallery;

import A_Super.Furniture;

public class Gal1_Armor extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal1_Armor() {
        super();
        this.searchable = false;
        this.description = "You know a set of samurai armor when you see one. "
                         + "This set is mostly black and brown with gold plating "
                         + "on the helmet. Not as colorful as what you've seen "
                         + "before, but this must be the functional kind.";
        this.searchDialog = "You find many little intricate parts to this piece, "
                          + "but nothing removable.";
        this.actDialog = "You will probably get hurt trying to do that.";
        this.addActKeys("wear", "equip");
        this.addNameKeys("samurai armor", "armor suit", "(?:suit of )?armor"); 
//-----------------------------------------------------------------------------
    }
}
