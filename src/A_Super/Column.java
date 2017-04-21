package A_Super;

import static A_Main.Names.FIXED_LADDER;
import static A_Main.Names.METAL_LADDER;
import static A_Main.Names.WEAPON;
/**
 * @author Kevin Rapa
 */
abstract public class Column extends Furniture implements Unmoveable {
    //-------------------------------------------------------------------------
    public Column () {
        super();

        this.actDialog = "You aren't very skilled at climbing vertical "
                       + "surfaces with your hands.";
        this.searchDialog = "There's nothing interesting on the column.";
        this.useDialog = "What are you trying to do? Bring the whole castle down?";

        this.addUseKeys(ANYTHING);
        this.addActKeys(CLIMBPATTERN);
    }
    //------------------------------------------------------------------------- 
    @Override public String useEvent(Item item) {
        if (item.getType().equals(WEAPON))
            return this.useDialog;
        else if (item.toString().equals(FIXED_LADDER) || item.toString().equals(METAL_LADDER))
            return "That'll get you up there, sure, but it's really not going to GET you anywhere...";
        else
            return DEFAULT_USE;
    }
    //------------------------------------------------------------------------- 
}


