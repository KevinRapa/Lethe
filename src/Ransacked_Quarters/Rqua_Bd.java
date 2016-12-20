package Ransacked_Quarters;

import Super.Furniture;
import Super.Room;
        
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
        this.interactDialog = "You move the bed out of the way, exposing a loose tile.";
        this.addNameKeys("bed");
        this.addActKeys("move", "pull", "push", "slide");
    }
/*----------------------------------------------------------------------------*/
        @Override public String interact(Room[][][] map, String key) {     
            String rep = "You have already moved the bed.";
            
            if (! this.moved) {
                rep = this.interactDialog;
                this.moved = true;
            }
        return rep;
    }
/*----------------------------------------------------------------------------*/
        public boolean isMoved() {
            return this.moved;
        }
/*----------------------------------------------------------------------------*/
}
