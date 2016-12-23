package Lookout;

import A_Super.Furniture;
import A_Super.Item;

public class Look_Rlng extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Look_Rlng(Item... items) {
        super(items);
        this.description = "A wide, sturdy granite railing.";
        this.searchDialog = "You search around the railing.";
        this.actDialog = "You grab the railing, but there's no fear of falling over,\n"
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
    @Override public String interact(String key) {     
        String rep = this.actDialog;
        
        if (this.doesThisHaveIt("looped rope")) {
            rep = "You take hold of the railing and peer outwards.\n"
                + "Something tied to the railing catches your eye.";
        }
        return rep;
    }
/*----------------------------------------------------------------------------*/
}

