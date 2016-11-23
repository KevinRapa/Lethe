package Lookout;

import Super.Furniture;
import Super.Item;
import Super.Room;

public class Look_Rlng extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Look_Rlng(String NAME, Item ... items) {
        super(NAME, items);
        this.description = "A wide, sturdy granite railing.";
        this.searchDialog = "You search around the railing.";
        this.interactDialog = "You grab the railing, but there's no fear of falling over,\n"
                    + "right?";
        this.addNameKeys("railing", "balcony railing");
        this.addActKeys("use", "grab", "hold");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        String rep = this.description;
        
        if (this.doesThisHaveIt("looped rope")) {
            rep = "A wide, sturdy granite railing. There appears to be\n"
                + "something tied to the bottom.";
        }
        return rep;
    }
/*----------------------------------------------------------------------------*/    
    @Override public String interact(Room[][][] map, String key) {     
        String rep = this.interactDialog;
        
        if (this.doesThisHaveIt("looped rope")) {
            rep = "You take hold of the railing and peer outwards.\n"
                + "Something tied to the railing catches your eye.";
        }
        return rep;
    }
/*----------------------------------------------------------------------------*/
}

