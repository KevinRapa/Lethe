package A_Super;

import static A_Main.Names.*;
import static A_Main.Patterns.LIFT_P;

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

        this.addUseKeys(ACETONE, ASH, SOIL, "sand|.+ dye", ".+ (?:wine|vinegar)");
        this.addActKeys(MOVEPATTERN, "admire", "lift|raise", "roll");
    }
    // ========================================================================   
    @Override public String interact(String key) {              
        if (key.matches(MOVEPATTERN) || LIFT_P.matcher(key).matches())
            return this.searchDialog;
        else if (key.equals("roll"))
            return "You're really not intending to take that with you, right?";
        else
            return this.actDialog;
    }
    // ========================================================================       
}


