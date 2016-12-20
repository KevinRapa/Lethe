package Foyer;

import Super.Furniture;
import Super.Room;

public class Foy2_Stat extends Furniture{
    private boolean moved;
    private final Furniture REF; 
    private final Room REF2;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Foy2_Stat(Furniture foy2Lvr, Room foy2) {
        super();
        this.searchable = false;
        this.moved = false;
        this.REF = foy2Lvr;
        this.REF2 = foy2;
        this.description = "A white marble statue. It depicts a woman holding\n"
                         + "a vessel of water on her shoulder. At its base,\n"
                         + "there appears to be some skid markings on the floor.";
        this.searchDialog = "The statue appears to hide nothing, although marks\n"
                          + "on the floor at its base suggest it's been moved to\n"
                          + "and from here frequently.";
        this.addActKeys("push", "pull", "move", "slide");
        this.addNameKeys("statue");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(Room[][][] map, String key) {
        if (! this.moved) {
            REF2.addFurniture(REF);
            this.moved = true;
            interactDialog = "You push the statue and manage to displace it a bit.\n"
                   + "In the alcove, behind the statue, you discover a lever."; 
        }
        else
            interactDialog = "You have moved the statue as far as you can.";
        
        return interactDialog;
    }
/*----------------------------------------------------------------------------*/
    public boolean getState() {
        return this.moved;
    }
/*----------------------------------------------------------------------------*/
}
