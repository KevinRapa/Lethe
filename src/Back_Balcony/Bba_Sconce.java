package Back_Balcony;

import A_Super.Furniture;
import A_Super.Unmoveable;

public class Bba_Sconce extends Furniture implements Unmoveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bba_Sconce() {
        super();
        this.description = "It's a copper metal sconce holding a glass bulb. It dimly " +
                           "lights the wall with a flickering orange glow.";
        this.actDialog = "Ouch! That's hot!";
        this.addActKeys(HOLDPATTERN);
        this.addNameKeys("(?:copper )?(?:metal )?(?:sconce|light)");
    }
//-----------------------------------------------------------------------------
    @Override public String moveIt() {
        return "Solidly mounted to the wall. No hidden lever here.";
    }
//-----------------------------------------------------------------------------
}
