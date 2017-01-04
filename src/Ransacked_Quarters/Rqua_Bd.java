package Ransacked_Quarters;

import A_Super.Furniture;
        
public class Rqua_Bd extends Furniture {
    private boolean moved;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Rqua_Bd () {
        super();
        this.searchable = false;
        this.moved = false;
        this.description = "It's a flimsy metal bedframe. ";
        this.searchDialog = "Nothing here. It's a bad place to hide something,\n"
                          + "as someone has already searched it. A tile beneath\n"
                          + "the bed looks suspicious, though.";
        this.actDialog = "You move the bed out of the way, exposing a loose tile.";
        this.addNameKeys("(?:flimsy )?(?:metal )?(?:bedframe|bed)");
        this.addActKeys("move", "pull", "push", "slide");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {     
        if (! this.moved) {
            this.moved = true;
            return this.actDialog;
        }
        return "You have already moved the bed.";
    }
/*----------------------------------------------------------------------------*/
    public boolean isMoved() {
        return this.moved;
    }
/*----------------------------------------------------------------------------*/
}
