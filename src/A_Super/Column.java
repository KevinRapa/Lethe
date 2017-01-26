package A_Super;

import static A_Main.NameConstants.WEAPON;
/**
 * @author Kevin Rapa
 */
abstract public class Column extends Furniture {
    // ========================================================================
    public Column () {
        super();

        this.actDialog = "Columns are pretty good for leaning against...";
        this.searchDialog = "There's nothing interesting on the column.";
        this.useDialog = "What are you trying to do? Bring the whole castle down?";

        this.addUseKeys(".+");
        this.addActKeys("lean");
    }
    // ======================================================================== 
    @Override public String useEvent(Item item) {
        if (item.getType().equals(WEAPON))
            return this.useDialog;
        else
            return DEFAULT_USE;
    }
    // ======================================================================== 
}


