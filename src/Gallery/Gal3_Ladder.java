package Gallery;

import A_Main.Id;
import A_Super.Staircase;
import A_Super.Direction;

public class Gal3_Ladder extends Staircase {
    private boolean lowered;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal3_Ladder() {
        super(Direction.UP, Id.GAL6, 16);

        this.description = "The ladder is suspended above the ground in the "
                         + "hatch, too high to grab hold of.";
        this.lowered = false;
        this.NAMEKEYS.clear();
        this.addNameKeys("ladder");
    }
//-----------------------------------------------------------------------------     
    @Override public String getDescription() {
        return (! this.lowered) ? this.description :
            "With the rope cut, the ladder now gives way to the gallery loft.";
    }
//-----------------------------------------------------------------------------
    public void lower() {
        this.lowered = true;
    }
//-----------------------------------------------------------------------------
    @Override public String interact(String key) {     
        if (this.lowered)
            return super.interact(key);
        else
            return "The ladder is too high up to climb.";
    }
//-----------------------------------------------------------------------------
}
