package A_Super;

/**
 * @author Kevin Rapa
 */
public class Column extends Furniture {
    // ========================================================================
    public Column () {
        super();

        this.actDialog = "Columns are pretty good for leaning against...";
        this.searchDialog = "There's nothing interesting on the column.";
        this.useDialog = "What are you trying to do? Bring the whole castle down?";

        this.addUseKeys(WEAPONS);
        this.addActKeys("lean");
    }
    // ======================================================================== 
}


