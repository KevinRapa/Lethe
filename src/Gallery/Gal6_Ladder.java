package Gallery;

import A_Main.Id;
import A_Super.Direction;
import A_Super.Staircase;

public class Gal6_Ladder extends Staircase {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal6_Ladder() {
        super(Direction.DOWN, Id.GAL3, 16);
        this.searchDialog = "The ladder hides nothing.";
        this.description = "The ladder leads down the hatch into the room below.";
        this.NAMEKEYS.clear();
        this.addNameKeys("(?:wood(?:en)? )?ladder");
    }
//-----------------------------------------------------------------------------
}
