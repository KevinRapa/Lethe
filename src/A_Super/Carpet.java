package A_Super;

/**
 * @author Kevin Rapa
 */
abstract public class Carpet extends Furniture {
    // ========================================================================
    public Carpet () {
        super();
        
        this.actDialog = "You take some valuable time to admire the carpet. Yes,\n"
                       + "what a wonderfully woven piece of artwork. It really\n"
                +        "would be a shame to get this dirty. What a wonderful rug.";
        this.useDialog = "Don't pour that on there! That would most certainly ruin it.";
        this.searchDialog = "There's nothing interesting under the carpet.";

        this.addUseKeys("acetone", "ash", "soil", "sand", ".+ dye", ".+ (?:wine|vinegar)");
        this.addActKeys(MOVEPATTERN, "admire", "lift|raise");
    }
    // ========================================================================   
    @Override public String interact(String key) {              
        if (key.matches(MOVEPATTERN) || key.matches("lift|raise"))
            return this.searchDialog;
        else
            return this.actDialog;
    }
    // ========================================================================       
}


