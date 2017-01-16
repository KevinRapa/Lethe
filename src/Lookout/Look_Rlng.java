package Lookout;

import A_Super.Furniture;
import A_Super.Item;

public class Look_Rlng extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Look_Rlng(Item... items) {
        super(items);
        this.description = "A wide, sturdy granite railing.";
        this.searchDialog = "You search around the railing.";
        this.actDialog = "You grab the railing, but there's no fear of falling over, right?";
        this.addNameKeys("(?:wide )?(?:sturdy )?(?:granite )?railing", "balcony railing");
        this.addActKeys("use", "grab", "hold");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        if (this.containsItem("looped rope")) {
            return "A wide, sturdy granite railing. There appears to be\n"
                 + "something tied to the bottom.";
        }
        return this.description;
    }
/*----------------------------------------------------------------------------*/    
    @Override public String interact(String key) {     
        if (this.containsItem("looped rope")) {
            return "You take hold of the railing and peer outwards.\n"
                 + "Something tied to the railing catches your eye.";
        }
        return this.actDialog;
    }
/*----------------------------------------------------------------------------*/
}

