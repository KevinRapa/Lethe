package Strange_Pool;

import static A_Main.Names.METAL_BAR;
import A_Super.Furniture;
import A_Super.Gettable;
/**
 * The grate the player climb out of in escaping the cell.
 * The player is not allowed to go backwards.
 * 
 * @author Kevin Rapa
 */
public class Sewp_Grate extends Furniture implements Gettable {
    //-------------------------------------------------------------------------
    public Sewp_Grate () {
        super();

        this.useDialog = "Why would you want to cover that back up?";
        this.description = "It's an open metal grate with the ladder descending "
                         + "into the hole that you escaped out of.";
        this.actDialog = "You've just escaped! No need to back into the dangerous tunnel.";

        this.addUseKeys(METAL_BAR);
        this.addNameKeys("(?:metal )?(?:ladder|grate)");
        this.addActKeys(GETPATTERN);
        this.addActKeys(CLIMBPATTERN, GETPATTERN);
    }
    //------------------------------------------------------------------------- 
    @Override public String interact(String key) {
        if (key.matches(CLIMBPATTERN))
            return this.actDialog;
        else
            return getIt();
    }
    //------------------------------------------------------------------------- 
}


