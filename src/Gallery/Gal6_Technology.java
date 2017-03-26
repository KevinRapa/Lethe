package Gallery;

import A_Super.Furniture;

public class Gal6_Technology extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal6_Technology() {
        super();

        this.description = "Wow! So much cool technology! This sure beats coal "
                         + "and steam.";
        this.searchDialog = "You can't decide which thing to search first!";
        this.useDialog = "You would have no idea what to do. This stuff is alien to you.";
        
        this.addUseKeys(ANYTHING);
        this.addNameKeys("(?:cool )?technology");
    }
/*----------------------------------------------------------------------------*/
}
