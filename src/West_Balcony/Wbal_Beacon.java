package West_Balcony;

import static A_Main.NameConstants.FIXED_LADDER;
import A_Super.Furniture;

public class Wbal_Beacon extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wbal_Beacon() {
        super();

        this.description = "It's a ten foot high stone obelisk. At the top is\n"
                         + "a large bowl of flame. It's so bright, I'm sure one\n"
                         + "could see this from a long distance.";
        this.searchDialog = "The beacon is too tall. Plus, it's on fire.";
        this.actDialog = "Your body isn't optimized for that sort of activity.";
        this.useDialog = "You think it better is stay as far from the roaring\n"
                       + "flame as possible. You wore your flammable overalls today.";
        
        this.addUseKeys(FIXED_LADDER);
        this.addActKeys(GETPATTERN, "extinguish");
        this.addNameKeys("(?:ten foot (?:high )?)?(?:stone )?(?:obelisk|beacon)");
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
