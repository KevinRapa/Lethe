package West_Outer_Wall;

import static A_Main.Names.WHEEL_SPOKE;
import A_Super.Item;
import A_Super.SearchableFurniture;

public class Wow1_Cart extends SearchableFurniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wow1_Cart(Item... items) {
        super(items);
        this.description = "It's a large, wooden cart with a wheel sitting off of\n"
                         + "its axle on the floor.";
        this.useDialog = "The spoke is probably of more use to you off of the wheel.";
        this.searchDialog = "It looks like everything's been removed from this cart.\n";
        this.actDialog = "What are you trying to do? The cart is clearly broken.";
        
        this.addUseKeys(WHEEL_SPOKE);
        this.addActKeys("ride|use", "fix|repair");
        this.addActKeys(MOVEPATTERN);
        this.addNameKeys("(?:large )?(?:wooden )?cart", "wheel");
    }    
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        if (key.equals("fix") || key.equals("repair"))
            return "You aren't really learned enough in the school of cart fixing...";
        else
            return this.actDialog;
    }
/*----------------------------------------------------------------------------*/
}
