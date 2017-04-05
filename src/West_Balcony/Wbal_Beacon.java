package West_Balcony;

import static A_Main.Names.FIXED_LADDER;
import A_Super.Furniture;
import A_Super.Unmoveable;

public class Wbal_Beacon extends Furniture implements Unmoveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wbal_Beacon() {
        super();

        this.description = "It's a ten foot high stone obelisk. At the top is "
                         + "a large bowl of flame. It's so bright, I'm sure one "
                         + "could see this from a long distance.";
        this.searchDialog = "The beacon is too tall. Plus, it's on fire.";
        this.actDialog = "Your body isn't optimized for that sort of activity.";
        this.useDialog = "You think it better is stay as far from the roaring "
                       + "flame as possible. You wore your flammable overalls today.";
        
        this.addUseKeys(FIXED_LADDER);
        this.addActKeys(GETPATTERN, "extinguish");
        this.addNameKeys("(?:ten foot (?:high )?)?(?:tall )?(?:stone )?(?:obelisk|beacon)");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        if (key.equals("extinguish"))
            return "The beacon is too tall for that.";
        else
            return this.actDialog;
    }
/*----------------------------------------------------------------------------*/
}
