package West_Outer_Wall;

import static A_Main.Names.FIXED_LADDER;
import A_Super.Staircase;
import A_Super.Direction;
/**
 * Created from the wooden rod, broken ladder, and wooden spoke.
 * 
 * @author Kevin Rapa
 */
public class Wow2_Ladder extends Staircase {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wow2_Ladder(Direction direction, String dest) {
        super(direction, dest, 16);
        this.searchDialog = "The ladder hides nothing.";
        this.description = "The ladder rests against the upper balcony, but it's "
                         + "unstable from the debris.";
        
        this.NAMEKEYS.clear();
        this.addNameKeys("ladder", FIXED_LADDER);
    }
//----------------------------------------------------------------------------- 
    @Override public String interact(String key) {     
        super.interact(key);
        return NOTHING;       
    }
//-----------------------------------------------------------------------------
}
